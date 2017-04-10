package com.taohj.fms.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/s")
@Controller
public class SecurityController {

	private static final String LOGIN_SUCCESS_VIEW = "/index";

	private static final String LOGIN_FAIL_VIEW = "/login";

	private static final String KEY_LOGIN = "login";

	private static final Logger log = LoggerFactory.getLogger(SecurityController.class);

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLoginForm(Model model, @ModelAttribute LoginCommand command) {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request, LoginCommand command) {
		UsernamePasswordToken token = new UsernamePasswordToken(command.getUsername(), command.getPassword(), command.isRememberMe());
		token.setHost(request.getRemoteHost());
		ModelAndView model = new ModelAndView();
		Map<String, String> data = new HashMap<String, String>();
		data.put("usernameState", "has-success");
		data.put("usernameDisplay", "hidden");
		data.put("usernameMsg", "登陆成功");
		try {
			SecurityUtils.getSubject().login(token);
			model.setViewName(LOGIN_SUCCESS_VIEW);
		} catch (UnknownAccountException e) {
			// 用户不存在
			String msg = "用户不存在！";
			model.setViewName(LOGIN_FAIL_VIEW);
			data.put("usernameState", "has-error");
			data.put("usernameDisplay", "show");
			data.put("usernameMsg", msg);
			log.error(msg, e);
		} catch (IncorrectCredentialsException e) {
			// 密码错误
			String msg = "密码错误";
			model.setViewName(LOGIN_FAIL_VIEW);
			data.put("passwordState", "has-error");
			data.put("passwordDisplay", "show");
			data.put("passwordMsg", msg);
			log.error(msg, e);
		} catch (AuthenticationException e) {
			String msg = e.getMessage();
			model.setViewName(LOGIN_FAIL_VIEW);
			data.put("passwordState", "has-error");
			data.put("passwordDisplay", "show");
			data.put("passwordMsg", msg);
			log.error(msg, e);
		}
		model.addObject(KEY_LOGIN, data);
		return model;
	}

	@RequestMapping("/logout")
	public String logout() {
		SecurityUtils.getSubject().logout();
		return "redirect:/s/login";
	}

}
