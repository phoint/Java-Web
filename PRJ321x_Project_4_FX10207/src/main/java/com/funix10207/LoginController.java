package com.funix10207;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.funix10207.dao.ProductDAO;
import com.funix10207.dao.UserDAO;
import com.funix10207.model.Product;
import com.funix10207.model.User;

/**
 * @author Admin
 *
 */
@Controller
@SessionAttributes("loginUser")
public class LoginController {
	private ApplicationContext context;

	@PostMapping("/login.html")
	public ModelAndView login(@ModelAttribute("loginUser") User user,HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("username");
		String pwd = request.getParameter("password");
		context = new ClassPathXmlApplicationContext("Beans.xml");
		UserDAO userDAO = (UserDAO) context.getBean("UserDAO");
		
		if (username != null && pwd != null) {
			User loginUser = null;
			try {
				loginUser = userDAO.getUser(username);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (loginUser != null && loginUser.getUserPwd().equals(pwd)) {
				return new ModelAndView("redirect:/");
			} else {
				return new ModelAndView("login", "error", "Username or password is invalid");
			} 
		} else {
			return new ModelAndView("login", "error", "please enter username and password");
		}
	}
	@ModelAttribute("loginUser")
	public User user(HttpServletRequest request) {
		context = new ClassPathXmlApplicationContext("Beans.xml");
		UserDAO userDAO = (UserDAO) context.getBean("UserDAO");
		User user = null;
		try {
			user = userDAO.getUser(request.getParameter("username"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	
	@GetMapping("/login.html")
	public String login() {
		return "login";
	}
	
	@GetMapping("/logoff.html")
	public String logoff(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "redirect:/";
	}
	
	@RequestMapping("/index.html")
	public ModelAndView home(HttpServletRequest request, HttpServletResponse response) {
		String searchKey = request.getParameter("searchKey");
		if (searchKey == null) {
			searchKey = "";
		}
		context = new ClassPathXmlApplicationContext("Beans.xml");
		ProductDAO productDAO = (ProductDAO) context.getBean("ProductDAO");
		List<Product> products = productDAO.listProduct(searchKey);

		return new ModelAndView("home", "products", products);
	}
}
