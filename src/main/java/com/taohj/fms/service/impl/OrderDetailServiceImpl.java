package com.taohj.fms.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.taohj.fms.model.OrderDetail;
import com.taohj.fms.service.OrderDetailService;
import com.taohj.fms.util.State;

import tk.mybatis.mapper.entity.Example;

@Service("orderDetailService")
public class OrderDetailServiceImpl extends BaseService<OrderDetail> implements OrderDetailService {

	@Override
	public List<OrderDetail> findOrderDetailByOrderNumber(long orderNumber) {
		Example example = new Example(OrderDetail.class);
		example.createCriteria()
		.andEqualTo("state", State.U.name())
		.andEqualTo("orderNumber", orderNumber);
		return selectByExample(example);
	}

}
