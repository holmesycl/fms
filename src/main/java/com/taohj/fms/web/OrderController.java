package com.taohj.fms.web;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.taohj.fms.service.OrderService;

@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@RequestMapping("/purchase")
	public String purchaseProduct(int productId, long purchaseAmount) {
		long userProductId = orderService.purchaseProduct(SecurityUtils.getSubject().getPrincipal().toString(), productId, purchaseAmount);
		return "redirect:/personal/product/" + userProductId;
	}

}
