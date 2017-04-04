package com.taohj.fms.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.taohj.fms.model.FinancialProduct;
import com.taohj.fms.service.FinancialProductService;
import com.taohj.fms.util.EffectiveExample;
import com.taohj.fms.util.State;
import com.taohj.fms.web.PageResult;
import com.taohj.fms.web.ProductCondition;

import tk.mybatis.mapper.entity.Example;

@Service("financialProductService")
public class FinancialProductServiceImpl extends BaseService<FinancialProduct> implements FinancialProductService {

	@Override
	public void saveFinancialProduct(FinancialProduct product) {
		Date cur = new Date();
		product.setCreateDate(cur);
		product.setLastModifyDate(cur);
		product.setState(State.U.name());
		save(product);
	}

	@Override
	public PageResult<FinancialProduct> queryProductByCondition(final ProductCondition productCondition, int pageNum, int pageSize) {
		Example example = new EffectiveExample(FinancialProduct.class) {

			@Override
			protected void fillCriteria(Criteria criteria) {
				if (productCondition.getProductId() != null) {
					criteria.andEqualTo("productId", productCondition.getProductId());
				}
				if (StringUtils.hasText(productCondition.getProductName())) {
					criteria.andLike("productName", "%" + productCondition.getProductName() + "%");
				}
				if (StringUtils.hasText(productCondition.getProductType())) {
					criteria.andEqualTo("productType", productCondition.getProductType());
				}
				if (StringUtils.hasText(productCondition.getRiskLevel())) {
					criteria.andEqualTo("riskLevel", productCondition.getRiskLevel());
				}
			}
		};
		PageHelper.startPage(pageNum, pageSize);
		Page<FinancialProduct> products = (Page<FinancialProduct>) this.selectByExample(example);
		return new PageResult<FinancialProduct>(products);
	}

	@Override
	public List<FinancialProduct> findTopExpectRateProduct(int page, int rows) {
		Example example = new EffectiveExample(FinancialProduct.class) {

			@Override
			protected void fillCriteria(Criteria criteria) {
			}
		};
		example.setOrderByClause("expect_rate desc");
		PageHelper.startPage(page, rows);
		return selectByExample(example);
	}

}
