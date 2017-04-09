package com.taohj.fms.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.taohj.fms.model.FinancialProduct;
import com.taohj.fms.service.IndexService;

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
	
	@Autowired
	private IndexService indexService;


	@RequestMapping(value = { "home" })
	public String home() {
		return HOME;
	}

	@RequestMapping(value = { "", "index" })
	public ModelAndView index() {
		ModelAndView model = new ModelAndView(INDEX);
		Map<String, List<FinancialProduct>> data = new HashMap<String, List<FinancialProduct>>();
		int page = 1;
		int rows = 3;
		List<FinancialProduct> topExpectRateProducts = indexService.findTopExpectRateProduct(page, rows);
		data.put("topExpectRateProducts", topExpectRateProducts);
		
		rows = 4;
		List<FinancialProduct> topRealRateProducts = indexService.findTopRealRateProduct(page, rows);
		data.put("topRealRateProducts", topRealRateProducts);
		
		rows = 8;
		List<FinancialProduct> topPopuProducts = indexService.findTopPopuProduct(page, rows);
		data.put("topPopuProducts", topPopuProducts);
		
		rows = 8;
		List<FinancialProduct> topNewProducts = indexService.findTopNewProducts(page, rows);
		data.put("topNewProducts", topNewProducts);
		model.addObject("data", data);
		return model;
	}

}
