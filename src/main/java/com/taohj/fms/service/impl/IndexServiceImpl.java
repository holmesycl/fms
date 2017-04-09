package com.taohj.fms.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.github.pagehelper.PageHelper;
import com.taohj.fms.model.FinancialProduct;
import com.taohj.fms.service.FinancialProductService;
import com.taohj.fms.service.IndexService;
import com.taohj.fms.service.OrderDetailService;
import com.taohj.fms.service.ProductRateService;
import com.taohj.fms.util.EffectiveExample;

import tk.mybatis.mapper.entity.Example;

@Service("indexService")
public class IndexServiceImpl extends BaseService<FinancialProduct> implements IndexService {

	@Autowired
	private FinancialProductService financialProductService;

	@Autowired
	private ProductRateService productRateService;

	@Autowired
	private OrderDetailService orderDetailService;

	@Override
	public List<FinancialProduct> findTopExpectRateProduct(int page, int rows) {
		Example example = new EffectiveExample(FinancialProduct.class) {

			@Override
			protected void fillCriteria(Criteria criteria) {
			}
		};
		example.setOrderByClause("expect_rate desc");
		PageHelper.startPage(page, rows);
		return financialProductService.selectByExample(example);
	}

	@Override
	public List<FinancialProduct> findTopRealRateProduct(int page, int rows) {
		List<Integer> productIds = productRateService.findTopRealRateProduct(page, rows);
		return fillProduct(productIds, page, rows);
	}

	private List<FinancialProduct> fillProduct(List<Integer> productIds, int page, int rows) {
		if (CollectionUtils.isEmpty(productIds)) {
			return findTopNewProducts(page, rows);
		} else {
			List<FinancialProduct> products = new ArrayList<FinancialProduct>();
			for (Integer productId : productIds) {
				products.add(financialProductService.selectByKey(productId));
			}
			if (products.size() < rows) {
				products.addAll(findTopNewProducts(page, rows - products.size()));
			}
			return products;
		}
	}

	@Override
	public List<FinancialProduct> findTopNewProducts(int page, int rows) {
		Example example = new EffectiveExample(FinancialProduct.class) {

			@Override
			protected void fillCriteria(Criteria criteria) {
			}
		};
		example.setOrderByClause("create_date desc");
		PageHelper.startPage(page, rows);
		return financialProductService.selectByExample(example);
	}

	@Override
	public List<FinancialProduct> findTopPopuProduct(int page, int rows) {
		List<Integer> productIds = orderDetailService.findTopPopuProduct(page, rows);
		return fillProduct(productIds, page, rows);
	}

}
