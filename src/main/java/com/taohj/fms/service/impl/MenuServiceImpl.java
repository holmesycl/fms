package com.taohj.fms.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taohj.fms.model.Menu;
import com.taohj.fms.model.RolePermission;
import com.taohj.fms.service.MenuService;
import com.taohj.fms.service.RolePermissionService;
import com.taohj.fms.util.EffectiveExample;

import tk.mybatis.mapper.entity.Example;

@Service("menuService")
public class MenuServiceImpl extends BaseService<Menu> implements MenuService {

	@Autowired
	private RolePermissionService rolePermissionService;

	@Override
	public List<Menu> selectMenuByRole(String role) {
		List<Menu> menus = new ArrayList<Menu>();
		List<RolePermission> rolePermissions = rolePermissionService.selectPermissionByRole(role);
		if (!CollectionUtils.isEmpty(rolePermissions)) {
			for (RolePermission rolePermission : rolePermissions) {
				String permission = rolePermission.getPermissionCode();
				Menu menu = selectMenuByPermissioin(permission);
				menus.add(menu);
			}
		}
		return menus;
	}

	@Override
	public Menu selectMenuByPermissioin(final String permission) {
		Example example = new EffectiveExample(Menu.class) {

			@Override
			protected void fillCriteria(Criteria criteria) {
				criteria.andEqualTo("menuCode", permission);

			}
		};
		return selectOne(example);
	}

}
