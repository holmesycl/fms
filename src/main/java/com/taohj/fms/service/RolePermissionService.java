package com.taohj.fms.service;

import java.util.List;

import com.taohj.fms.model.RolePermission;

public interface RolePermissionService extends IService<RolePermission> {

	/**
	 * 根据角色编码获取用户权限
	 * 
	 * @param role
	 *            用户角色
	 * @return 角色权限
	 */
	List<RolePermission> selectPermissionByRole(final String role);

}
