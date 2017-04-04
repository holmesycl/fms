package com.taohj.fms.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	/**
	 * 管理系统首页
	 */
	private static final String HOME = "home";

	/**
	 * 产品首页
	 */
	private static final String INDEX = "index";

	@RequestMapping(value = { "home" })
	public String home() {
		return HOME;
	}

	@RequestMapping(value = { "", "index.jsp", "index.html", "index" })
	public String index() {
		return INDEX;
	}

}
