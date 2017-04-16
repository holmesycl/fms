package com.taohj.fms.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.taohj.fms.model.FinancialProduct;
import com.taohj.fms.model.IncomeDetail;
import com.taohj.fms.service.FinancialProductService;
import com.taohj.fms.service.IncomeDetailService;
import com.taohj.fms.util.State;
import com.taohj.fms.util.TimeUtil;
import com.taohj.fms.web.model.IncomeDetailModel;

import tk.mybatis.mapper.entity.Example;

@Service("incomeDetailService")
public class IncomeDetailServiceImpl extends BaseService<IncomeDetail> implements IncomeDetailService {

	@Autowired
	private FinancialProductService financialProductService;

	@Override
	public List<IncomeDetailModel> findIncomeDetailByUsernameAndProduct(String username, int productId) {

		List<IncomeDetailModel> models = new ArrayList<IncomeDetailModel>();

		Example example = new Example(IncomeDetail.class);
		example.createCriteria().andEqualTo("state", State.U.name()).andEqualTo("username", username).andEqualTo("productId", productId);
		example.setOrderByClause("create_date desc");
		List<IncomeDetail> incomeDetails = selectByExample(example);
		if (!CollectionUtils.isEmpty(incomeDetails)) {
			for (IncomeDetail incomeDetail : incomeDetails) {
				IncomeDetailModel model = new IncomeDetailModel();
				try {
					BeanUtils.copyProperties(model, incomeDetail);
					FinancialProduct product = financialProductService.selectByKey(productId);
					model.setProductName(product.getProductName());
					models.add(model);
				} catch (IllegalAccessException e) {
					throw new RuntimeException(e);
				} catch (InvocationTargetException e) {
					throw new RuntimeException(e);
				}
			}
		}
		return models;
	}

	@Override
	public Long findIncomeByUsernameAndProduct(String username, int productId) {
		Example example = new Example(IncomeDetail.class);
		example.createCriteria().andEqualTo("state", State.U.name()).andEqualTo("username", username).andEqualTo("productId", productId);
		List<IncomeDetail> incomeDetails = selectByExample(example);
		Long income = 0L;
		if (!CollectionUtils.isEmpty(incomeDetails)) {
			for (IncomeDetail incomeDetail : incomeDetails) {
				income += incomeDetail.getAmount();
			}
		}
		return income;
	}

	@Override
	public Long findYesterdayIncomeByUsernameAndProduct(String username, int productId) {
		return findIncomeByUsernameAndProduct(username, productId, TimeUtil.plus(-1).now());
	}

	@Override
	public Long findIncomeByUsernameAndProduct(String username, int productId, Date date) {
		Example example = new Example(IncomeDetail.class);
		example.createCriteria().andEqualTo("state", State.U.name()).andEqualTo("username", username).andEqualTo("productId", productId)
				.andBetween("createDate", TimeUtil.date(date).start(), TimeUtil.date(date).end());
		List<IncomeDetail> incomeDetails = selectByExample(example);
		Long income = 0L;
		if (!CollectionUtils.isEmpty(incomeDetails)) {
			for (IncomeDetail incomeDetail : incomeDetails) {
				income += incomeDetail.getAmount();
			}
		}
		return income;
	}

}
