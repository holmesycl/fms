package com.taohj.fms.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taohj.fms.model.FinancialProduct;
import com.taohj.fms.model.OrderDetail;
import com.taohj.fms.model.ProductOrder;
import com.taohj.fms.model.UserProduct;
import com.taohj.fms.service.FinancialProductService;
import com.taohj.fms.service.OrderDetailService;
import com.taohj.fms.service.OrderService;
import com.taohj.fms.service.UserProductService;
import com.taohj.fms.util.OrderNumberUtil;
import com.taohj.fms.util.State;
import com.taohj.fms.util.TimeUtil;
import com.taohj.fms.util.UserProductUtil;

@Service("orderService")
public class OrderServiceImpl extends BaseService<ProductOrder> implements OrderService {

	@Autowired
	private OrderDetailService orderDetailService;

	@Autowired
	private FinancialProductService financialProductService;

	@Autowired
	private UserProductService userProductService;

	@Override
	public long purchaseProduct(String username, int productId, long purchaseAmount) {
		ProductOrder order = new ProductOrder();
		Date cur = new Date();
		long orderNumber = OrderNumberUtil.get();
		order.setOrderNumber(orderNumber);
		order.setBusinessType("1"); // 购买
		order.setState(State.U.name());
		order.setUsername(username);
		order.setCreateDate(cur);
		save(order);

		OrderDetail detail = new OrderDetail();
		detail.setOrderNumber(orderNumber);
		long userProductId = UserProductUtil.getId(orderNumber, 1);
		detail.setUserProductId(userProductId);
		detail.setAmount(purchaseAmount);
		detail.setProductId(productId);
		detail.setCreateDate(cur);
		detail.setState(State.U.name());
		// 次日算收益，次日生效
		Date effectiveDate = TimeUtil.plus(1).start();
		detail.setEffectiveDate(effectiveDate);
		// 生效日 + 投资期限
		FinancialProduct product = financialProductService.selectByKey(productId);
		detail.setExpireDate(TimeUtil.plus(effectiveDate, product.getProductTerm()).end());
		orderDetailService.save(detail);

		UserProduct userProduct = new UserProduct();
		userProduct.setUserProductId(userProductId);
		userProduct.setAmount(purchaseAmount);
		userProduct.setProductId(productId);
		userProduct.setCreateDate(cur);
		userProduct.setState(State.U.name());
		userProduct.setUsername(username);
		userProduct.setEffectiveDate(detail.getEffectiveDate());
		// 生效日 + 投资期限
		userProduct.setExpireDate(detail.getExpireDate());
		userProductService.save(userProduct);

		return userProductId;
	}

}
