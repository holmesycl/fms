package com.taohj.fms.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.taohj.fms.model.UserRole;
import com.taohj.fms.service.UserRoleService;
import com.taohj.fms.util.EffectiveExample;

import tk.mybatis.mapper.entity.Example;

@Service("userRoleService")
public class UserRoleServiceImpl extends BaseService<UserRole> implements UserRoleService {

	@Override
	public List<UserRole> selectRoleByUsername(final String username) {
		Example example = new EffectiveExample(UserRole.class) {
			
			@Override
			protected void fillCriteria(Criteria criteria) {
				criteria.andEqualTo("username", username);
			}
		};
		return selectByExample(example);
	}

}
