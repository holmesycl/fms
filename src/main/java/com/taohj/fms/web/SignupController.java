package com.taohj.fms.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/signup")
@Controller
public class SignupController {

	private static final String SIGN_UP_PAGE = "signup";

	private static final Logger log = LoggerFactory.getLogger(SignupController.class);

	@RequestMapping(value = { "/", "/indx" })
	public String showSignupPage() {
		return SIGN_UP_PAGE;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveUser(HttpServletRequest request, SignupCommand signupCommand) {
		if (log.isTraceEnabled()) {
			log.trace(signupCommand + "");
		}
		try {
			
		} catch (Exception e) {
			
		}
		
		// 注册完毕后，直接登陆
		UsernamePasswordToken token = new UsernamePasswordToken(signupCommand.getUsername(), signupCommand.getPassword(), true);
		token.setHost(request.getRemoteHost());
		SecurityUtils.getSubject().login(token);
		
		return "redirect:/home";
	}
}
