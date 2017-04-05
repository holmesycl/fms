package com.taohj.fms.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.taohj.fms.model.FinancialProduct;
import com.taohj.fms.model.UserProduct;
import com.taohj.fms.service.FinancialProductService;
import com.taohj.fms.service.UserProductService;
import com.taohj.fms.util.State;
import com.taohj.fms.web.PageResult;
import com.taohj.fms.web.model.UserProductModel;

import tk.mybatis.mapper.entity.Example;

@Service("userProductService")
public class UserProductServiceImpl extends BaseService<UserProduct> implements UserProductService {

	@Autowired
	private FinancialProductService financialProductService;

	@Override
	public PageResult<UserProductModel> findProduct(String username, int page, int rows) {
		Example example = new Example(UserProduct.class);
		example.createCriteria().andEqualTo("state", State.U.name());

		PageHelper.startPage(page, rows);
		Page<UserProduct> userProducts = (Page<UserProduct>) selectByExample(example);

		PageResult<UserProductModel> models = new PageResult<UserProductModel>();
		if (!CollectionUtils.isEmpty(userProducts)) {
			List<UserProductModel> vals = new ArrayList<UserProductModel>();
			for (UserProduct userProduct : userProducts) {
				UserProductModel model = new UserProductModel();
				try {
					BeanUtils.copyProperties(model, userProduct);
					int productId = userProduct.getProductId();
					FinancialProduct product = financialProductService.selectByKey(productId);
					model.setProductName(product.getProductName());
					vals.add(model);
				} catch (IllegalAccessException e) {
					throw new RuntimeException(e);
				} catch (InvocationTargetException e) {
					throw new RuntimeException(e);
				}
			}
			models.setTotal(userProducts.getTotal());
			models.setRows(vals);
		}
		return models;
	}

	@Override
	public UserProductModel findProduct(long userProductId) {
		UserProduct userProduct = selectByKey(userProductId);
		Assert.notNull(userProduct);
		UserProductModel model = new UserProductModel();
		try {
			BeanUtils.copyProperties(model, userProduct);
			int productId = userProduct.getProductId();
			FinancialProduct product = financialProductService.selectByKey(productId);
			model.setProductName(product.getProductName());
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		} catch (InvocationTargetException e) {
			throw new RuntimeException(e);
		}
		return model;
	}

}
