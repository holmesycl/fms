package com.taohj.fms.service;

import java.util.List;

import com.taohj.fms.model.Menu;

public interface MenuService extends IService<Menu> {

	/**
	 * 根据用户角色查询菜单
	 * 
	 * @param role
	 *            用户角色
	 * @return 菜单
	 */
	List<Menu> selectMenuByRole(String role);

	/**
	 * 根据权限获取菜单
	 * 
	 * @param permission
	 *            权限
	 * @return 菜单
	 */
	Menu selectMenuByPermissioin(final String permission);

}
