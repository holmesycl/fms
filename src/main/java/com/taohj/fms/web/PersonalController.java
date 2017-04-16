package com.taohj.fms.web;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.taohj.fms.model.TransactionFlow;
import com.taohj.fms.model.User;
import com.taohj.fms.model.UserAccount;
import com.taohj.fms.service.TransactionFlowService;
import com.taohj.fms.service.UserAccountService;
import com.taohj.fms.service.UserProductService;
import com.taohj.fms.service.UserService;
import com.taohj.fms.util.WebResponse;
import com.taohj.fms.web.model.UserProductModel;

@Controller
@RequestMapping("/personal")
public class PersonalController {

	@Autowired
	private UserProductService userProductService;

	@Autowired
	private UserService userService;

	@Autowired
	private UserAccountService userAccountService;

	@Autowired
	private TransactionFlowService transactionFlowService;

	@RequestMapping("/user/basicInfo")
	public ModelAndView showUserBasicInfo(ModelAndView model) {
		String username = (String) SecurityUtils.getSubject().getPrincipal();
		User user = userService.selectByUsername(username);
		model.setViewName("personal/basicInfo");
		model.addObject("user", user);
		return model;
	}

	@RequestMapping("/user/updateBasicInfo")
	@ResponseBody
	public WebResponse updateUserBasicInfo(User user) {
		String username = (String) SecurityUtils.getSubject().getPrincipal();
		user.setUsername(username);
		WebResponse webResponse = null;
		try {
			userService.updateUserInfo(user);
			webResponse = WebResponse.info("用户信息修改成功。");
		} catch (Exception e) {
			webResponse = WebResponse.info("用户信息修改失败。");
		}
		return webResponse;
	}

	@RequestMapping("/product/list")
	public ModelAndView listProduct(ModelAndView model) {
		String username = (String) SecurityUtils.getSubject().getPrincipal();
		int page = 1;
		int rows = 20;
		PageResult<UserProductModel> userProducts = userProductService.findProduct(username, page, rows);
		model.setViewName("personal/list");
		model.addObject("uesrProducts", userProducts);
		return model;
	}

	@RequestMapping("/product/{userProductId}")
	public ModelAndView showProduct(@PathVariable long userProductId, ModelAndView model) {
		String username = (String) SecurityUtils.getSubject().getPrincipal();
		UserProductModel userProduct = userProductService.findModelByUsernameAndUserProduct(username, userProductId);
		model.setViewName("personal/view");
		model.addObject("userProduct", userProduct);
		return model;
	}

	@RequestMapping("/account")
	public ModelAndView showAccountInfo(ModelAndView model) {
		String username = (String) SecurityUtils.getSubject().getPrincipal();
		UserAccount account = userAccountService.findAccountByUsername(username);
		model.setViewName("account/view");
		model.addObject("account", account);
		return model;
	}

	@RequestMapping("/account/flow")
	public ModelAndView showAccountFlow(ModelAndView model) {
		String username = (String) SecurityUtils.getSubject().getPrincipal();
		List<TransactionFlow> flows = transactionFlowService.findFlowByUsername(username);
		model.setViewName("account/flow");
		model.addObject("flows", flows);
		return model;
	}

}
