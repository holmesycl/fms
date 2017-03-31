package com.taohj.fms.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/prod")
public class ProductController {

	private static final String HOME = "/prod/mgt";

	@RequestMapping(value = { "/mgt" })
	public String home() {
		return HOME;
	}

}
