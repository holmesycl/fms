package com.taohj.fms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.taohj.fms.mapper.OrderDetailMapper;
import com.taohj.fms.model.OrderDetail;
import com.taohj.fms.service.OrderDetailService;
import com.taohj.fms.util.State;

import tk.mybatis.mapper.entity.Example;

@Service("orderDetailService")
public class OrderDetailServiceImpl extends BaseService<OrderDetail> implements OrderDetailService {

	@Autowired
	private OrderDetailMapper orderDetailMapper;

	@Override
	public List<OrderDetail> findOrderDetailByOrderNumber(long orderNumber) {
		Example example = new Example(OrderDetail.class);
		example.createCriteria().andEqualTo("state", State.U.name()).andEqualTo("orderNumber", orderNumber);
		return selectByExample(example);
	}

	@Override
	public List<Integer> findTopPopuProduct(int page, int rows) {
		PageHelper.startPage(page, rows);
		return orderDetailMapper.selectProductGroupByProductIdAndOrderByCount();
	}

}
