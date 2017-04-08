package com.taohj.fms.web;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.taohj.fms.service.OrderService;
import com.taohj.fms.web.model.OrderModel;

@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@RequestMapping("/purchase")
	public String purchaseProduct(int productId, long purchaseAmount) {
		long orderNunber = orderService.purchaseProduct(SecurityUtils.getSubject().getPrincipal().toString(), productId, purchaseAmount);
		return "redirect:/order/show/" + orderNunber;
	}

	@RequestMapping("/show/{orderNumber}")
	public ModelAndView showOrder(@PathVariable long orderNumber) {
		ModelAndView model = new ModelAndView("order/view");
		OrderModel order = orderService.selectOrderModelByOrderNumber(orderNumber);
		model.addObject("order", order);
		return model;
	}

	@RequestMapping("/pedeem/{productId}")
	public String pedeemProduct(@PathVariable int productId, long userProductId, long amount) {
		String username = (String) SecurityUtils.getSubject().getPrincipal();
		long orderNumber = orderService.pedeemProduct(username, productId, userProductId, amount * 100);
		return "redirect:/order/show/" + orderNumber;
	}

}
