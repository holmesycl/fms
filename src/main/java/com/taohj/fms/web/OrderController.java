package com.taohj.fms.web;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.taohj.fms.service.OrderService;

@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@RequestMapping("/purchase")
	public ModelAndView purchaseProduct(int productId, long purchaseAmount) {
		ModelAndView model = new ModelAndView("userProd/view");
		long orderNumber = orderService.purchaseProduct(SecurityUtils.getSubject().getPrincipal().toString(), productId, purchaseAmount);
		model.addObject("orderNumber", orderNumber);
		return model;
	}

}
