package com.taohj.fms.service;

import java.util.List;

import com.taohj.fms.model.FinancialProduct;

public interface IndexService extends IService<FinancialProduct> {

	List<FinancialProduct> findTopExpectRateProduct(int page, int rows);

	List<FinancialProduct> findTopRealRateProduct(int page, int rows);

	List<FinancialProduct> findTopNewProducts(int page, int rows);

	List<FinancialProduct> findTopPopuProduct(int page, int rows);

}
