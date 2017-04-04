package com.taohj.fms.service;

import com.taohj.fms.model.ProductOrder;

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
	long purchaseProduct(String username,int productId, long purchaseAmount);

}
