package com.taohj.fms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.taohj.fms.mapper.ProductRateMapper;
import com.taohj.fms.model.ProductRate;
import com.taohj.fms.service.ProductRateService;
import com.taohj.fms.util.State;
import com.taohj.fms.util.TimeUtil;

import tk.mybatis.mapper.entity.Example;

@Service("productRateService")
public class ProductRateServiceImpl extends BaseService<ProductRate> implements ProductRateService {

	@Autowired
	protected ProductRateMapper productRateMapper;

	@Override
	public List<ProductRate> findProductTodayRate() {
		Example example = new Example(ProductRate.class);
		example.createCriteria().andEqualTo("state", State.U.name()).andEqualTo("effectiveDate", TimeUtil.plus(0).start()).andEqualTo("expireDate",
				TimeUtil.plus(0).end());
		return selectByExample(example);
	}

	@Override
	public List<Integer> findTopRealRateProduct(int page, int rows) {
		PageHelper.startPage(page, rows);
		return productRateMapper.selectProductOrderByRate();
	}

}
