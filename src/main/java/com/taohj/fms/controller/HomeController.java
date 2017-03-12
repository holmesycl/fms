package com.taohj.fms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	private static final String HOME = "home";

	@RequestMapping(value = { "", "index.jsp", "index.html", "index" })
	public String home() {
		return HOME;
	}
}
