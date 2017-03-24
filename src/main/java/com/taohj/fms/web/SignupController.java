package com.taohj.fms.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.taohj.fms.service.UserService;

@RequestMapping("/signup")
@Controller
public class SignupController {

	private static final String SIGN_UP_PAGE = "signup";

	@Autowired
	private UserService userService;

	@RequestMapping(value = { "", "/", "/indx" })
	public String showSignupPage() {
		return SIGN_UP_PAGE;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveUser(HttpServletRequest request, SignupCommand signupCommand) {
		userService.createUser(signupCommand.getUsername(), signupCommand.getPassword(), signupCommand.getEmail());
		return "redirect:/s/login";
	}
}
