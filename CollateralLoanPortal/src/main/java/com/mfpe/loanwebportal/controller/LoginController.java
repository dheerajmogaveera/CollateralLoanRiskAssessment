package com.mfpe.loanwebportal.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.mfpe.loanwebportal.feign.AuthClient;
import com.mfpe.loanwebportal.modelvo.Admin;

@Controller
public class LoginController {

	@Autowired
	AuthClient authClient;
	static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@GetMapping("/login")
	public String login() {
		logger.info("Showing the login page to the user");
		return "Login";
	}

	@PostMapping("/login")
	public String login1(@ModelAttribute Admin admin, HttpServletRequest request) {
		logger.info("Showing the result of login page to the user");
		System.out.println(admin);
		ResponseEntity<Admin> login = authClient.login(admin);
		String tokenHeader = login.getBody().getAuthToken();
		// check if it is not null


		request.getSession().setAttribute("token", tokenHeader);
		request.getSession().setAttribute("login", true);
		return "Home";


	}

	@GetMapping("/home")
	public String getHome(HttpServletRequest request) {
		logger.info("Showing the home page to the user");
		if (request.getSession().getAttribute("login") != null)
			return "Home";
		else
			return "redirect:/login";
	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		logger.info("Showing the logout page to the user");
		request.getSession().invalidate();
		return "redirect:/login";
	}
}
