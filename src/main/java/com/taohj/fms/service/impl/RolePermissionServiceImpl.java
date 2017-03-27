package com.taohj.fms.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.taohj.fms.model.RolePermission;
import com.taohj.fms.service.RolePermissionService;
import com.taohj.fms.util.EffectiveExample;

import tk.mybatis.mapper.entity.Example;

@Service("rolePermissionService")
public class RolePermissionServiceImpl extends BaseService<RolePermission> implements RolePermissionService {

	@Override
	public List<RolePermission> selectPermissionByRole(final String roleCode) {
		Example example = new EffectiveExample(RolePermission.class) {
			
			@Override
			protected void fillCriteria(Criteria criteria) {
				criteria.andEqualTo("roleCode", roleCode);
				
			}
		};
		return selectByExample(example);
	}

}
