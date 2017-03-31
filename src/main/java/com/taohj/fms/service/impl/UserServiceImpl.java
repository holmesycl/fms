package com.taohj.fms.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.taohj.fms.model.User;
import com.taohj.fms.model.UserPwdSalt;
import com.taohj.fms.model.UserRole;
import com.taohj.fms.pagination.PageCondition;
import com.taohj.fms.pagination.PageResult;
import com.taohj.fms.pagination.SimplePageResult;
import com.taohj.fms.service.UserPwdSaltService;
import com.taohj.fms.service.UserRoleService;
import com.taohj.fms.service.UserService;
import com.taohj.fms.util.EffectiveExample;
import com.taohj.fms.util.PwdUtil;
import com.taohj.fms.util.State;
import com.taohj.fms.util.TimeUtil;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

@Service("userService")
public class UserServiceImpl extends BaseService<User> implements UserService {

	@Autowired
	private UserPwdSaltService userPwdSaltService;

	@Autowired
	private UserRoleService userRoleService;

	@Override
	public User saveUser(User user) {
		this.save(user);
		return user;
	}

	@Override
	public PageResult<User> selectAll(User user, PageCondition pageCondition) {
		Example example = new Example(User.class);
		Criteria criteria = example.createCriteria();
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
	public User createUser(int userType, String username, String password, String email) {
		Assert.notNull(username, "用户名[username]不能为空.");
		Assert.notNull(password, "密码[password]不能为空.");
		Assert.notNull(email, "邮箱[email]不能为空.");

		UserPwdSalt userPwdSalt = userPwdSaltService.createUserPwdSalt(username);

		User user = new User();
		user.setUsername(username);
		user.setPassword(PwdUtil.sha256Hash(password, userPwdSalt.getSalt()));
		user.setEmail(email);
		Date cur = new Date();
		user.setCreateDate(cur);
		user.setEffectiveDate(cur);
		user.setExpireDate(TimeUtil.expireDate());
		user.setState(State.U.name());
		this.save(user);

		/*
		 * 赋予角色
		 */
		UserRole userRole = new UserRole();
		userRole.setUsername(username);
		userRole.setCreateDate(cur);
		userRole.setEffectiveDate(cur);
		userRole.setExpireDate(TimeUtil.expireDate());
		userRole.setState(State.U.name());
		// 普通用户
		if (userType == 1) {
			userRole.setRoleCode("normal");
		}
		// 银行用户
		else if (userType == 2) {
			userRole.setRoleCode("bank");
		} else {
			// ..
		}
		userRoleService.save(userRole);
		return user;
	}

	@Override
	public User selectByUsername(final String username) {
		Example example = new EffectiveExample(User.class) {

			@Override
			protected void fillCriteria(Criteria criteria) {
				criteria.andEqualTo("username", username);

			}
		};
		return selectOne(example);
	}

}