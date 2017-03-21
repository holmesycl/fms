package com.taohj.fms.service.impl;

import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.taohj.fms.model.User;
import com.taohj.fms.pagination.PageCondition;
import com.taohj.fms.pagination.PageResult;
import com.taohj.fms.pagination.SimplePageResult;
import com.taohj.fms.service.UserService;

import tk.mybatis.mapper.entity.Example;

@Service("userService")
public class UserServiceImpl extends BaseService<User> implements UserService {

	@Override
	public User saveUser(User user) {
		this.save(user);
		return user;
	}

	@Override
	public PageResult<User> selectAll(User user, PageCondition pageCondition) {
		Example example = new Example(User.class);
		Example.Criteria criteria = example.createCriteria();
		if (user != null) {
			if (user.getUserId() > 0) {
				criteria.andEqualTo("user_id", user.getUserId());
			}
		}

		// 分页查询
		Page<User> page = PageHelper.startPage(pageCondition.getPageSize(), pageCondition.getPageSize());
		selectByExample(example);

		return SimplePageResult.create(page);
	}

}
