package nhom07.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import nhom07.entity.Category;
import nhom07.entity.Product;
import nhom07.service.CategoryService;
import nhom07.service.ProductService;

@Controller
@RequestMapping({ "/danh-muc", "/category" })
public class CategoryController {
	@Autowired
	CategoryService categoryService;
	@Autowired
	private ProductService productService;

	@GetMapping("/id={categoryID}/page={pages}")
	public String listProductPage(@PathVariable int categoryID, @PathVariable int pages,
			Model model,HttpServletRequest request, HttpSession session) {

		
		Category category = categoryService.getCategory(categoryID);
		if (category == null)
			return "redirect:/";
		
		int filter = 1;
		if(request.getParameter("orderby") != null) {
			filter = Integer.valueOf(request.getParameter("orderby"));
			session.setAttribute("orderby", filter);
		}else {
			if(session.getAttribute("orderby") != null)
				filter = (int)session.getAttribute("orderby");
		}

		int cnt = 0;
		List<Product> products;
		if(filter == 1)
			products = productService.getProductsbyDK(" where categoryID=" + categoryID);
		else if(filter == 2)
			products = productService.getProductsbyDK(" where categoryID=" + categoryID + " order by price asc");
		else
			products = productService.getProductsbyDK(" where categoryID=" + categoryID + " order by price desc");
		List<Product> products_2 = new ArrayList<Product>();
		for (Product p : products) {
			if (cnt > (pages - 1) * 8 && cnt <= pages * 8)
				products_2.add(p);
			cnt++;
		}
		model.addAttribute("products", products_2);
		model.addAttribute("category", category);
		model.addAttribute("size_product", cnt);
		model.addAttribute("page", pages);
//		if (pages == 1)
//			return "redirect:/category/id=" + categoryID;
//		if (products.size() == 0)
//			return "redirect:/category/id=" + categoryID;
		return "customer/DanhSachSanPham";
	}

	@GetMapping("/id={categoryID}")
	public String listProduct(@PathVariable int categoryID, Model model) {
		Category category = categoryService.getCategory(categoryID);
		return "redirect:/category/id="+categoryID+"/page=1";
	}
	
}
