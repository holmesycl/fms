package com.taohj.fms.service.impl;

import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.taohj.fms.model.User;
import com.taohj.fms.service.UserService;
import com.taohj.fms.web.Pagination;

@Service("userService")
public class UserServiceImpl extends BaseService<User> implements UserService {

	@Override
	public User saveUser(User user) {
		this.save(user);
		return user;
	}

	@Override
	public Pagination<User> selectAll(int page, int rows) {
		Page<User> paUsers = PageHelper.startPage(page, rows);
		this.selectByExample(null);
		return new Pagination<User>(paUsers.getTotal(), paUsers.getResult());
	}

}
