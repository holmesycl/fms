package com.taohj.fms.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.taohj.fms.model.User;
import com.taohj.fms.pagination.PageCondition;
import com.taohj.fms.pagination.PageResult;
import com.taohj.fms.pagination.SimplePageResult;
import com.taohj.fms.service.UserPwdSaltService;
import com.taohj.fms.service.UserService;
import com.taohj.fms.util.State;

import tk.mybatis.mapper.entity.Example;

@Service("userService")
public class UserServiceImpl extends BaseService<User> implements UserService {

	@Autowired
	private UserPwdSaltService userPwdSaltService;
	
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

	@Override
	public User createUser(String username, String password, String email) {
		
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);
		Date cur = new Date();
		user.setCreateDate(cur);
		user.setEffectiveDate(cur);
		user.setExpireDate(cur);
		user.setState(State.U.name());
		save(user);
		
		userPwdSaltService.createUserPwdSalt(username);
		
		return user;
	}

}
