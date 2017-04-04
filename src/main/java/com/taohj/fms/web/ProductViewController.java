package com.taohj.fms.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.taohj.fms.model.FinancialProduct;
import com.taohj.fms.service.FinancialProductService;

@Controller
@RequestMapping("/view/product")
public class ProductViewController {

	@Autowired
	private FinancialProductService financialProductService;
	
	@RequestMapping("/{productId}")
	public ModelAndView viewProduct(@PathVariable int productId){
		ModelAndView model = new ModelAndView("prod/view");
		FinancialProduct product = financialProductService.selectByKey(productId);
		model.addObject("product", product);
		return model;
	}
}
