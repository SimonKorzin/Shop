package com.korzin.web.controller;

import com.korzin.objects.Customer;
import com.korzin.objects.CustomerRole;
import com.korzin.services.CustomerRoleService;
import com.korzin.services.CustomerService;
import com.korzin.services.GroupsService;
import com.korzin.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {

	@Autowired
	CustomerService customerService;
	@Autowired
	CustomerRoleService customerRoleService;
	@Autowired
	private ProductService productService;
	@Autowired
	private GroupsService groupsService;
	@RequestMapping(value = { "/","/welcome**" }, method = RequestMethod.GET)
	public ModelAndView defaultPage() {
		ModelAndView model = new ModelAndView();
		model.addObject("title", "Shop");
		model.addObject("message", "This is default page!");
//		model.addObject("id", )
		model.setViewName("hello");
		return model;
	}
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String homeWork(Model model){
		return "home";
	}
	@RequestMapping(value = "/admin**", method = RequestMethod.GET)
	public ModelAndView adminPage() {
		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security + Hibernate Example");
		model.addObject("message", "This page is for ROLE_ADMIN only!");
		model.setViewName("admin");
		return model;

	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, HttpServletRequest request) {
		System.out.println("in login " + error + " " + logout);
		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", getErrorMessage(request, "SPRING_SECURITY_LAST_EXCEPTION"));
		}
		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		model.setViewName("login");
		return model;
	}

	// customize the error message
	private String getErrorMessage(HttpServletRequest request, String key) {
		Exception exception = (Exception) request.getSession().getAttribute(key);
		String error = "";
		if (exception instanceof BadCredentialsException) {
			error = "Invalid username and password!";
		} else if (exception instanceof LockedException) {
			error = exception.getMessage();
		} else {
			error = "Invalid username and password!";
		}
		return error;
	}

	// for 403 access denied page
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView accesssDenied() {
		ModelAndView model = new ModelAndView();
		// check if user is login
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			System.out.println(userDetail);
			model.addObject("username", userDetail.getUsername());
		}
		model.setViewName("403");
		return model;
	}
	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String getRegistrationForm(){return "registration";}
	@RequestMapping(value = "/registration",method = RequestMethod.POST)
	public String doRegistration( @RequestParam(value = "username") String username,
									   @RequestParam(value = "password") String password,
									   @RequestParam(value = "firstName") String firstName,
									   @RequestParam(value = "lastName") String lastName,
									   @RequestParam(value = "email") String email,
									   @RequestParam(value = "country") String country,
									   @RequestParam(value = "city") String city,
									   @RequestParam(value = "street") String street,
									   @RequestParam(value = "house") String house, Model model){
		Customer customer = new Customer(username,password,false,firstName,lastName,email,null,country,city,street,house,0);
		customerService.addOrUpdate(customer);
		CustomerRole customerRole = new CustomerRole(customerService.findByUsername(username),"ROLE_USER");
		System.out.println("CUSTOMER_ROLE ADD: role = " + customerRole.getRole() + " getCustomer.getFirstName = " + customerRole.getCustomer().getFirst_name() );
		customerRoleService.add(customerRole);
		model.addAttribute("products", productService.findAll());
		model.addAttribute("groups", groupsService.findAll());
		return "catalog";
	}
}