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
		try {
			SecurityUtils.getSubject().login(token);
			model.setViewName(LOGIN_SUCCESS_VIEW);
		} catch (UnknownAccountException e) {
			// 用户不存在
			String msg = "用户不存在！";
			model = createModelAndView("UnknownAccount", msg);
			model.addObject("username", command.getUsername());
			log.error(msg, e);
		} catch (IncorrectCredentialsException e) {
			// 密码错误
			String msg = "密码错误";
			model = createModelAndView("IncorrectCredentials", msg);
			model.addObject("username", command.getUsername());
			log.error(msg, e);
		} catch (AuthenticationException e) {
			model = createModelAndView("other", e.getMessage());
			model.addObject("username", command.getUsername());
			log.error(e.getMessage(), e);
		}
		return model;
	}

	private ModelAndView createModelAndView(String loginState, String loginMsg) {
		ModelAndView model = new ModelAndView();
		Map<String, String> data = new HashMap<String, String>();
		if ("UnknownAccount".equals(loginState)) {
			data.put("usernameState", "has-error");
			data.put("usernameDisplay", "show");
			data.put("usernameMsg", loginMsg);
			model.setViewName(LOGIN_FAIL_VIEW);
		} else if ("IncorrectCredentials".equals(loginState)) {
			data.put("passwordState", "has-error");
			data.put("passwordDisplay", "show");
			data.put("passwordMsg", loginMsg);
			model.setViewName(LOGIN_FAIL_VIEW);
		} else if ("other".equals(loginState)) {
			data.put("otherState", "has-error");
			data.put("otherDisplay", "show");
			data.put("otherMsg", loginMsg);
			model.setViewName(LOGIN_FAIL_VIEW);
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
