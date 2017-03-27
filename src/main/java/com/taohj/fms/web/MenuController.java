package com.taohj.fms.web;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taohj.fms.model.Menu;
import com.taohj.fms.service.MenuService;

@Controller
@RequestMapping("/menu")
public class MenuController {

	@Autowired
	private MenuService menuService;

	/**
	 * 普通用户角色
	 */
	private static final String ROLE_NORMAL = "normal";

	/**
	 * 银行用户角色
	 */
	private static final String ROLE_BANK = "bank";

	@RequestMapping("/all")
	@ResponseBody
	public List<Menu> getUserMenu() {
		List<Menu> menus = new ArrayList<Menu>();
		String role = null;
		if (SecurityUtils.getSubject().hasRole(ROLE_BANK)) {
			role = ROLE_BANK;
		} else if (SecurityUtils.getSubject().hasRole(ROLE_NORMAL)) {
			role = ROLE_NORMAL;
		}
		List<Menu> vals = menuService.selectMenuByRole(role);
		if (!CollectionUtils.isEmpty(vals)) {
			menus = vals;
		}
		return menus;
	}

}
