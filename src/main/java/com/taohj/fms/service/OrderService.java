package com.taohj.fms.service;

import com.taohj.fms.model.ProductOrder;
import com.taohj.fms.web.model.OrderModel;

public interface OrderService extends IService<ProductOrder> {

	/**
	 * 购买理财产品
	 * 
	 * @param productId
	 *            产品ID
	 * @param purchaseAmount
	 *            购买金额
	 * @return 订单流水
	 */
	long purchaseProduct(String username, int productId, long purchaseAmount);

	/**
	 * 根据订单编号查询订单数据
	 * 
	 * @param orderNumber
	 *            订单编号
	 * @return
	 */
	OrderModel selectOrderModelByOrderNumber(long orderNumber);

	/**
	 * 根据订单编号查询订单。
	 * 
	 * @param orderNumber
	 *            订单编号
	 * @return
	 */
	ProductOrder findOrderByOrderNumber(long orderNumber);

	/**
	 * 赎回理财产品
	 * 
	 * @param username
	 * @param productId
	 * @param userProductId
	 * @param amount
	 * @return
	 */
	long pedeemProduct(String username, int productId, long userProductId, long amount);

}
