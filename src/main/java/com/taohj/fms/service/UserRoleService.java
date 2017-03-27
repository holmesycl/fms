package com.taohj.fms.service;

import java.util.List;

import com.taohj.fms.model.UserRole;

public interface UserRoleService extends IService<UserRole> {

	/**
	 * 根据用户名获取用户角色.
	 * 
	 * @param username
	 *            用户名
	 * @return 用户角色
	 */
	List<UserRole> selectRoleByUsername(final String username);

}
