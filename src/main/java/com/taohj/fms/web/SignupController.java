package com.taohj.fms.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.taohj.fms.exception.UserExistException;
import com.taohj.fms.service.UserService;

@RequestMapping("/signup")
@Controller
public class SignupController {

	private static final String SIGN_UP_PAGE = "signup";

	private static final String SIGN_UP_SUCCESS_VIEW = "index";

	private static final String SIGN_UP_FAIL_VIEW = SIGN_UP_PAGE;

	private static final String KEY_SIGNUP = "signup";

	private static final Logger log = LoggerFactory.getLogger(SignupController.class);

	@Autowired
	private UserService userService;

	@RequestMapping(value = { "", "/", "/indx" })
	public String showSignupPage() {
		return SIGN_UP_PAGE;
	}

	@RequestMapping(value = "/save")
	public ModelAndView saveUser(SignupCommand signupCommand, HttpServletRequest request) {
		ModelAndView model = new ModelAndView();
		try {
			userService.createUser(signupCommand.getUserType(), signupCommand.getUsername(), signupCommand.getPassword(), signupCommand.getEmail());
			UsernamePasswordToken token = new UsernamePasswordToken(signupCommand.getUsername(), signupCommand.getPassword(), true);
			token.setHost(request.getRemoteHost());
			SecurityUtils.getSubject().login(token);
			model.setViewName(SIGN_UP_SUCCESS_VIEW);
		} catch (UserExistException e) {
			model = createModelAndView("UserExist", e.getMessage());
			log.error(e.getMessage(), e);
		} catch (Exception e) {
			model = createModelAndView("other", e.getMessage());
			log.error(e.getMessage(), e);
		}
		return model;
	}

	private ModelAndView createModelAndView(String loginState, String loginMsg) {
		ModelAndView model = new ModelAndView();
		Map<String, String> data = new HashMap<String, String>();
		if ("UserExist".equals(loginState)) {
			data.put("usernameState", "has-error");
			data.put("usernameDisplay", "show");
			data.put("usernameMsg", loginMsg);
			model.setViewName(SIGN_UP_FAIL_VIEW);
		} else if ("other".equals(loginState)) {
			data.put("otherState", "has-error");
			data.put("otherDisplay", "show");
			data.put("otherMsg", loginMsg);
			model.setViewName(SIGN_UP_FAIL_VIEW);
		}
		model.addObject(KEY_SIGNUP, data);
		return model;
	}
}
