package com.taohj.fms.web;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.taohj.fms.model.UserLoginInfo;
import com.taohj.fms.service.UserLoginInfoService;
import com.taohj.fms.util.State;

@RequestMapping("/s")
@Controller
public class SecurityController {

	@Autowired
	private UserLoginInfoService userLoginInfoService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLoginForm(Model model, @ModelAttribute LoginCommand command) {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpServletRequest request, LoginCommand command) {
		UsernamePasswordToken token = new UsernamePasswordToken(command.getUsername(), command.getPassword(), command.isRememberMe());
		token.setHost(request.getRemoteHost());
		String remark = "登录成功";
		String loginState = "1";
		try {
			SecurityUtils.getSubject().login(token);
		} catch (AuthenticationException e) {
			remark = e.getMessage();
			loginState = "2";
		}
		// 记录登录日志
		UserLoginInfo loginInfo = new UserLoginInfo();
		loginInfo.setCreateDate(new Date());
		loginInfo.setHost(token.getHost());
		loginInfo.setLoginDate(new Date());
		loginInfo.setUsername(command.getUsername());
		loginInfo.setLoginState(loginState);
		loginInfo.setState(State.U.name());
		loginInfo.setRemark(remark);
		userLoginInfoService.save(loginInfo);
		
		return "redirect:/s/login";
	}

	@RequestMapping("/logout")
	public String logout() {
		SecurityUtils.getSubject().logout();
		return "redirect:/s/login";
	}

}
