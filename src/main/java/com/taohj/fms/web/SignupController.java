package com.taohj.fms.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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

	@RequestMapping(value = "/save")
	public void saveUser(SignupCommand signupCommand, HttpServletRequest request) {
		userService.createUser(signupCommand.getUserType(), signupCommand.getUsername(), signupCommand.getPassword(), signupCommand.getEmail());
		UsernamePasswordToken token = new UsernamePasswordToken(signupCommand.getUsername(), signupCommand.getPassword(), true);
		token.setHost(request.getRemoteHost());
		SecurityUtils.getSubject().login(token);
	}
}
