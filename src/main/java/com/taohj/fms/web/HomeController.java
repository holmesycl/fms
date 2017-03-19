package com.taohj.fms.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	private static final String HOME = "home";
	
	private static final String LOGIN = "login";

	@RequestMapping(value = { "", "index.jsp", "index.html", "index" })
	public String home() {
		return HOME;
	}
	
	
	@RequestMapping("/login")
	public String login() {
		return LOGIN;
	}
}
