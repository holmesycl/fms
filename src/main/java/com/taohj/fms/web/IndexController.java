package com.taohj.fms.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taohj.fms.model.FinancialProduct;
import com.taohj.fms.service.FinancialProductService;

@Controller
@RequestMapping("/index")
public class IndexController {

	@Autowired
	private FinancialProductService financialProductService;

	@RequestMapping("/data")
	@ResponseBody
	public Map<String, List<FinancialProduct>> getDate() {
		Map<String, List<FinancialProduct>> data = new HashMap<String, List<FinancialProduct>>();
		int page = 1;
		int topExpectRateProduct = 3;
		List<FinancialProduct> topExpectRateProducts = financialProductService.findTopExpectRateProduct(page, topExpectRateProduct);
		data.put("TOP_EXPECT_RATE", topExpectRateProducts);
		
		return data;
	}

}
