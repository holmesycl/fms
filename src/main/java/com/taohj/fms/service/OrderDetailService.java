package com.taohj.fms.service;

import java.util.List;

import com.taohj.fms.model.OrderDetail;

public interface OrderDetailService extends IService<OrderDetail> {

	List<OrderDetail> findOrderDetailByOrderNumber(long orderNumber);

}
