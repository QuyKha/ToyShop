package nhom07.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import nhom07.entity.Account;
import nhom07.entity.Role;
import nhom07.entity.User;
import nhom07.service.AccountService;
import nhom07.service.UserService;

@Controller
@RequestMapping({"/registration", "dang-ky"})
public class RegistrationController {
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private UserService userService ;
	
	
	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	@InitBinder
	public void initBiner(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	@GetMapping({"","/"})
	public String registration(@ModelAttribute("Account") Account account, Model theModel ) {
		
		theModel.addAttribute("Account", new Account());
		return "Registration";
	}
	
	@PostMapping("/processRegistrationForm")
	public String processRegistrationForm(@Valid @ModelAttribute("Account") Account account, BindingResult bindingResult,
			Model theModel) {
		if (bindingResult.hasErrors()) {
			theModel.addAttribute("Account", account);
			return "Registration";
		}
		String phone = account.getPhone();
		String password = account.getPassword();
		
		Account account2 = accountService.getAccount(phone);
		if(account2 != null) {
			theModel.addAttribute("registrationError", "Tài khoản đã tồn tại");
			return "Registration";
		}
		
		String encodedPassword = passwordEncoder.encode(password);
		encodedPassword = "{bcrypt}" + encodedPassword;
		
		account.setAccountID(0);
		account.setEnabled(1);
		account.setPassword(encodedPassword);
		account.setRole(new Role(2));
		accountService.saveAccount(account);
		account2 = new Account();
		account2.setAccountID(accountService.lastID());
				
		User newUser = new User();
		newUser.setUserID(0);
		newUser.setPhone(phone);
		newUser.setFullName("");
		newUser.setAddress("");
		newUser.setAccount(account2);
		newUser.setEmail("");
		
		userService.saveUser(newUser);		
		
		return "redirect:/login";
	}
}
