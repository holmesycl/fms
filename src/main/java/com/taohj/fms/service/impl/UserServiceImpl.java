package com.taohj.fms.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.taohj.fms.model.User;
import com.taohj.fms.model.UserPwdSalt;
import com.taohj.fms.pagination.PageCondition;
import com.taohj.fms.pagination.PageResult;
import com.taohj.fms.pagination.SimplePageResult;
import com.taohj.fms.service.UserPwdSaltService;
import com.taohj.fms.service.UserService;
import com.taohj.fms.util.PwdUtil;
import com.taohj.fms.util.State;
import com.taohj.fms.util.TimeUtil;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

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
	public User createUser(String username, String password, String email) {
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

		return user;
	}

	@Override
	public User selectByUsername(String username) {
		Example example = new Example(User.class);
		Criteria criteria = example.createCriteria();
		criteria.andEqualTo("username", username);
		criteria.andEqualTo("state", State.U.name());
		Date cur = new Date();
		criteria.andGreaterThanOrEqualTo("expireDate", cur);
		criteria.andLessThanOrEqualTo("effectiveDate", cur);
		List<User> users = selectByExample(example);
		if (CollectionUtils.isEmpty(users)) {
			return null;
		}
		Assert.state(users.size() == 1);
		return users.get(0);
	}

}