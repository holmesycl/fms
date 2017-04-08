package com.taohj.fms.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.taohj.fms.model.FinancialProduct;
import com.taohj.fms.model.UserProduct;
import com.taohj.fms.service.FinancialProductService;
import com.taohj.fms.service.IncomeDetailService;
import com.taohj.fms.service.UserProductService;
import com.taohj.fms.util.EffectiveExample;
import com.taohj.fms.util.State;
import com.taohj.fms.util.TimeUtil;
import com.taohj.fms.web.PageResult;
import com.taohj.fms.web.model.IncomeDetailModel;
import com.taohj.fms.web.model.UserProductModel;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

@Service("userProductService")
public class UserProductServiceImpl extends BaseService<UserProduct> implements UserProductService {

	@Autowired
	private FinancialProductService financialProductService;

	@Autowired
	private IncomeDetailService incomeDetailService;

	@Override
	public PageResult<UserProductModel> findProduct(String username, int page, int rows) {
		Example example = new Example(UserProduct.class);
		example.createCriteria().andEqualTo("username", username).andEqualTo("state", State.U.name());

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
	public UserProductModel findModelByUsernameAndUserProduct(String username, long userProductId) {
		UserProduct userProduct = selectByKey(userProductId);
		Assert.notNull(userProduct);
		UserProductModel model = new UserProductModel();
		try {
			BeanUtils.copyProperties(model, userProduct);
			int productId = userProduct.getProductId();
			List<IncomeDetailModel> incomeDetails = incomeDetailService.findIncomeDetailByUsernameAndProduct(username, productId);
			long income = 0L;
			if (!CollectionUtils.isEmpty(incomeDetails)) {
				for (IncomeDetailModel incomeDetailModel : incomeDetails) {
					income += incomeDetailModel.getAmount();
				}
			}
			model.setIncome(income);
			FinancialProduct product = financialProductService.selectByKey(productId);
			model.setProductName(product.getProductName());
			model.setTermType(product.getTermType());
			if ("1".equals(product.getTermType())) {
				model.setPedeemLimit("到期后可赎回");
				model.setEndDate(DateFormatUtils.format(userProduct.getExpireDate(), "yyyy-MM-dd"));
				if (new Date().after(userProduct.getExpireDate())) {
					model.setCanPedeem("1");
				} else {
					model.setCanPedeem("2");
				}
			} else if ("2".equals(product.getTermType())) {
				model.setPedeemLimit("可立即赎回");
				model.setCanPedeem("1");
				model.setEndDate("无");
			}
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		} catch (InvocationTargetException e) {
			throw new RuntimeException(e);
		}
		return model;
	}

	@Override
	public List<UserProduct> findByUsernameAndProduct(String username, long productId, int effectiveType) {
		Example example = new Example(UserProduct.class);
		Criteria criteria = example.createCriteria();
		criteria.andEqualTo("state", State.U.name()).andEqualTo("username", username).andEqualTo("productId", productId);
		Date cur = new Date();
		// 今天生效
		if (effectiveType == 1) {
			criteria.andGreaterThanOrEqualTo(EffectiveExample.PROPERTY_EXPIRE_DATE, cur);
			criteria.andLessThan(EffectiveExample.PROPERTY_EFFECTIVE_DATE, TimeUtil.plus(1).start());
		}
		// 次日生效
		else if (effectiveType == 2) {
			// 生效时间 > 明天0点0分0秒
			criteria.andGreaterThanOrEqualTo(EffectiveExample.PROPERTY_EFFECTIVE_DATE, TimeUtil.plus(1).start());
		}
		// 已失效
		else if (effectiveType == 3) {
			criteria.andLessThanOrEqualTo(EffectiveExample.PROPERTY_EXPIRE_DATE, cur);
		}
		// 当前有效 + 次日生效
		else if (effectiveType == 4) {
			criteria.andGreaterThanOrEqualTo(EffectiveExample.PROPERTY_EXPIRE_DATE, cur);
		}
		// 已失效 + 当前有效 + 次日生效
		else if (effectiveType == 5) {

		}
		return selectByExample(example);
	}

	@Override
	public List<UserProduct> findExpireDateGreaterTodayByUsernameAndProduct(String username, int productId) {
		Example example = new Example(UserProduct.class);
		Criteria criteria = example.createCriteria();
		criteria.andEqualTo("state", State.U.name()).andEqualTo("username", username).andEqualTo("productId", productId)
		.andGreaterThanOrEqualTo(EffectiveExample.PROPERTY_EXPIRE_DATE, TimeUtil.plus(1).start());
		return selectByExample(example);
	}

	@Override
	public List<UserProduct> findExpireDateGreaterNowUserProduct() {
		Example example = new Example(UserProduct.class);
		example.createCriteria().andEqualTo("state", State.U.name()).andGreaterThanOrEqualTo(EffectiveExample.PROPERTY_EXPIRE_DATE, new Date());
		return selectByExample(example);
	}

}
