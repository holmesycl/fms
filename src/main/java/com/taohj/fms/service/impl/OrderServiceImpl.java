package com.taohj.fms.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

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
import com.taohj.fms.web.model.OrderModel;

import tk.mybatis.mapper.entity.Example;

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

		FinancialProduct product = financialProductService.selectByKey(productId);
		Assert.notNull(product);
		String termType = product.getTermType();
		purchaseAmount = purchaseAmount * 100;

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
		// 定期
		if ("1".equals(termType)) {
			detail.setExpireDate(TimeUtil.plus(effectiveDate, product.getProductTerm()).end());
		} else if ("2".equals(termType)) {
			detail.setExpireDate(TimeUtil.expireDate());
		}
		orderDetailService.save(detail);

		// 活期产品
		if ("2".equals(termType)) {
			// 查询明天生效
			List<UserProduct> userProducts = userProductService.findExpireDateGreaterTodayByUsernameAndProduct(username, productId);
			if (!CollectionUtils.isEmpty(userProducts)) {
				Assert.state(userProducts.size() == 1);
				UserProduct userProduct = userProducts.get(0);
				userProduct.setState(State.E.name());
				purchaseAmount += userProduct.getAmount();
				userProductService.updateNotNull(userProduct);
			}
		}
		UserProduct userProduct = new UserProduct();
		userProduct.setUserProductId(userProductId);
		userProduct.setAmount(purchaseAmount);
		userProduct.setProductId(productId);
		userProduct.setCreateDate(cur);
		userProduct.setState(State.U.name());
		userProduct.setUsername(username);
		userProduct.setEffectiveDate(detail.getEffectiveDate());
		userProduct.setExpireDate(detail.getExpireDate());
		userProductService.save(userProduct);

		return orderNumber;
	}

	@Override
	public OrderModel selectOrderModelByOrderNumber(long orderNumber) {
		OrderModel orderModel = new OrderModel();
		ProductOrder productOrder = findOrderByOrderNumber(orderNumber);
		try {
			BeanUtils.copyProperties(orderModel, productOrder);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		} catch (InvocationTargetException e) {
			throw new RuntimeException(e);
		}
		List<OrderDetail> orderDetails = orderDetailService.findOrderDetailByOrderNumber(orderNumber);
		Assert.state(orderDetails.size() == 1); // 当前只有订单详情
		OrderDetail orderDetail = orderDetails.get(0);
		try {
			BeanUtils.copyProperties(orderModel, orderDetail);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		} catch (InvocationTargetException e) {
			throw new RuntimeException(e);
		}
		FinancialProduct product = financialProductService.selectByKey(orderDetail.getProductId());
		orderModel.setProductName(product.getProductName());
		return orderModel;
	}

	@Override
	public ProductOrder findOrderByOrderNumber(long orderNumber) {
		Example example = new Example(ProductOrder.class);
		example.createCriteria().andEqualTo("state", State.U.name()).andEqualTo("orderNumber", orderNumber);

		List<ProductOrder> orders = selectByExample(example);
		if (!CollectionUtils.isEmpty(orders)) {
			Assert.state(orders.size() == 1);
			return orders.get(0);
		}
		return null;
	}
	
	@Override
	public long pedeemProduct(String username, int productId, long userProductId, long amount) {

		ProductOrder order = new ProductOrder();
		Date cur = new Date();
		long orderNumber = OrderNumberUtil.get();
		order.setOrderNumber(orderNumber);
		order.setBusinessType("2"); // 赎回
		order.setState(State.U.name());
		order.setUsername(username);
		order.setCreateDate(cur);
		save(order);

		UserProduct userProduct = userProductService.selectByKey(userProductId);
		OrderDetail detail = new OrderDetail();
		detail.setOrderNumber(orderNumber);
		detail.setUserProductId(userProductId);
		detail.setAmount(amount);
		detail.setProductId(productId);
		detail.setCreateDate(cur);
		detail.setState(State.U.name());
		detail.setEffectiveDate(userProduct.getEffectiveDate());
		detail.setExpireDate(cur);
		orderDetailService.save(detail);
		// 立即失效
		userProduct.setExpireDate(cur);

		long leftAmount = userProduct.getAmount() - amount;
		if (leftAmount > 0) {
			UserProduct nextUserProduct = new UserProduct();
			try {
				BeanUtils.copyProperties(nextUserProduct, userProduct);
			} catch (IllegalAccessException e) {
				throw new RuntimeException(e);
			} catch (InvocationTargetException e) {
				throw new RuntimeException(e);
			}
			nextUserProduct.setUserProductId(UserProductUtil.getId(orderNumber, 1));
			nextUserProduct.setAmount(leftAmount);
			nextUserProduct.setCreateDate(cur);
			userProductService.save(nextUserProduct);
		}
		return orderNumber;
	}

}
