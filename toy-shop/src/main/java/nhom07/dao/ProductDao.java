package nhom07.dao;

import java.util.List;

import nhom07.entity.Product;

public interface ProductDao {
	public List<Product> getProducts();
	public List<Product> getProductsbyDK(String dk);
	public List<Product> getProductsFilter(String name, int categoryID, String newProduct, String bestSaler, String[] rangePrice, String[] rangeStock);
	public void saveProduct(Product product);
	public Product getProduct(int id);
	public void deleteProduct(int id);
}
