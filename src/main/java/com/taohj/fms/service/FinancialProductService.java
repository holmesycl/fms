package com.taohj.fms.service;

import java.util.List;

import com.taohj.fms.model.FinancialProduct;
import com.taohj.fms.web.PageResult;
import com.taohj.fms.web.ProductCondition;

public interface FinancialProductService extends IService<FinancialProduct> {

	/**
	 * 保存理财产品
	 * 
	 * @param product
	 */
	void saveFinancialProduct(FinancialProduct product);

	/**
	 * 分页查询
	 * 
	 * @param productCondition
	 * @param pageCondition
	 * @return
	 */
	PageResult<FinancialProduct> queryProductByCondition(final ProductCondition productCondition, int pageNum, int pageSize);

	
	List<FinancialProduct> findAllProduct();


}
