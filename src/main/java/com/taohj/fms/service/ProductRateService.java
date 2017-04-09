package com.taohj.fms.service;

import java.util.List;

import com.taohj.fms.model.ProductRate;

public interface ProductRateService extends IService<ProductRate> {

	/**
	 * 获取产品当天的利率.
	 * 
	 * @return
	 */
	List<ProductRate> findProductTodayRate();

	List<Integer> findTopRealRateProduct(int page, int rows);

}
