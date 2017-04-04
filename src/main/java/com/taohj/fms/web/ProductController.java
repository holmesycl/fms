package com.taohj.fms.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taohj.fms.model.FinancialProduct;
import com.taohj.fms.service.FinancialProductService;
import com.taohj.fms.util.WebResponse;

@Controller
@RequestMapping("/prod")
public class ProductController {

	private final Logger log = LoggerFactory.getLogger(getClass());

	private final String HOME = "prod/mgt";

	@Autowired
	private FinancialProductService financialProductService;

	@RequestMapping(value = { "/mgt" })
	public String home() {
		return HOME;
	}

	@RequestMapping("/save")
	@ResponseBody
	public WebResponse saveProd(FinancialProduct product) {
		WebResponse response = null;
		try {
			financialProductService.saveFinancialProduct(product);
			response = WebResponse.info("理财产品保存成功");
		} catch (Exception e) {
			response = WebResponse.error(e.getMessage());
		}
		return response;
	}

	@RequestMapping("/query")
	@ResponseBody
	public PageResult<FinancialProduct> queryProductByCondition(ProductCondition productCondition, int page, int rows) {
		PageResult<FinancialProduct> pageResult = new PageResult<FinancialProduct>();
		try {
			pageResult = financialProductService.queryProductByCondition(productCondition, page, rows);
		} catch (Exception e) {
			log.error("理财产品查询错误", e);
		}
		return pageResult;
	}

}
