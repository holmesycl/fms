package com.taohj.fms.web;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.taohj.fms.service.UserProductService;
import com.taohj.fms.web.model.UserProductModel;

@Controller
@RequestMapping("/personal")
public class PersonalController {

	@Autowired
	private UserProductService userProductService;

	@RequestMapping("/product/list")
	public ModelAndView listProduct(ModelAndView model) {
		String username = (String) SecurityUtils.getSubject().getPrincipal();
		int page = 1;
		int rows = 20;
		PageResult<UserProductModel> userProducts = userProductService.findProduct(username, page, rows);
		model.setViewName("personal/list");
		model.addObject("uesrProducts", userProducts);
		return model;
	}

	@RequestMapping("/product/{userProductId}")
	public ModelAndView showProduct(@PathVariable long userProductId, ModelAndView model) {
		String username = (String) SecurityUtils.getSubject().getPrincipal();
		UserProductModel userProduct = userProductService.findModelByUsernameAndUserProduct(username, userProductId);
		model.setViewName("personal/view");
		model.addObject("userProduct", userProduct);
		return model;
	}

}
