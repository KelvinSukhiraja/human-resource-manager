package com.hr.controllers;

import java.security.Principal;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hr.DAO.UserDAO;
import com.hr.pojo.Job;
import com.hr.pojo.User;

@Controller
public class LoginController {
	@Autowired
	UserDAO userDAO;
	
	@RequestMapping("/")
	public String homepage(Model model, Principal principal, Authentication auth) {
		String username = principal.getName();
		Collection<? extends GrantedAuthority> authority = auth.getAuthorities();
		model.addAttribute("username", username);
		model.addAttribute("role", authority);
		
		return "homepage";
	}
	
	@GetMapping("/userlogin")
	public String loginPage(Model model) {
		
		return "login";
	}
	
	@GetMapping("/signup")
	public String signup(@ModelAttribute("signup") User user) {
		
		return "signup";
	}
	
	@PostMapping("/process-signup")
	public String processSignup(User user) {
		userDAO.saveUser(user);
		return "redirect:/userlogin";
	}
	
	@GetMapping("/showUser")
	public String viewUser(Model model) {
		
		List<User> userList = userDAO.loadUser();
		model.addAttribute("user", userList);
		
		return "view-user";
	}
}
