package com.taohj.fms.web;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.taohj.fms.service.IncomeDetailService;
import com.taohj.fms.web.model.IncomeDetailModel;

@Controller
@RequestMapping("/income")
public class IncomeController {

	private static final String PERSONAL_INCOMEDETAIL = "personal/incomeDetail";

	@Autowired
	private IncomeDetailService incomeDetailService;

	@RequestMapping("/detail/{productId}")
	public ModelAndView showIncomeDetail(@PathVariable Integer productId) {
		ModelAndView model = new ModelAndView(PERSONAL_INCOMEDETAIL);
		String username = SecurityUtils.getSubject().getPrincipal().toString();
		List<IncomeDetailModel> incomeDetails = incomeDetailService.findIncomeDetailByUsernameAndProduct(username, productId);
		model.addObject("incomeDetails", incomeDetails);
		return model;
	}

}
