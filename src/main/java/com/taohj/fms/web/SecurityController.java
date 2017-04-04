package com.taohj.fms.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/s")
@Controller
public class SecurityController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLoginForm(Model model, @ModelAttribute LoginCommand command) {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpServletRequest request, LoginCommand command) {
		UsernamePasswordToken token = new UsernamePasswordToken(command.getUsername(), command.getPassword(), command.isRememberMe());
		token.setHost(request.getRemoteHost());
		try {
			SecurityUtils.getSubject().login(token);
		} catch (AuthenticationException e) {
			
		}
		return "redirect:/";
	}

	@RequestMapping("/logout")
	public String logout() {
		SecurityUtils.getSubject().logout();
		return "redirect:/";
	}

}
