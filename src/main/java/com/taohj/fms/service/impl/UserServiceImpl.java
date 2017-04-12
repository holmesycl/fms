package com.taohj.fms.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import com.taohj.fms.exception.UserExistException;
import com.taohj.fms.model.User;
import com.taohj.fms.model.UserAccount;
import com.taohj.fms.model.UserPwdSalt;
import com.taohj.fms.model.UserRole;
import com.taohj.fms.service.UserAccountService;
import com.taohj.fms.service.UserPwdSaltService;
import com.taohj.fms.service.UserRoleService;
import com.taohj.fms.service.UserService;
import com.taohj.fms.util.EffectiveExample;
import com.taohj.fms.util.FlowType;
import com.taohj.fms.util.PwdUtil;
import com.taohj.fms.util.State;
import com.taohj.fms.util.TimeUtil;

import tk.mybatis.mapper.entity.Example;

@Service("userService")
public class UserServiceImpl extends BaseService<User> implements UserService {

	@Autowired
	private UserPwdSaltService userPwdSaltService;

	@Autowired
	private UserRoleService userRoleService;

	@Autowired
	private UserAccountService userAccountService;

	@Override
	public User createUser(int userType, String username, String password, String email) {
		Assert.notNull(username, "用户名[username]不能为空.");
		Assert.notNull(password, "密码[password]不能为空.");
		Assert.notNull(email, "邮箱[email]不能为空.");

		// 校验用户是否已存在
		User user = selectByUsername(username);
		if (user != null) {
			throw new UserExistException("用户" + username + "已存在！");
		}

		UserPwdSalt userPwdSalt = userPwdSaltService.createUserPwdSalt(username);

		user = new User();
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

		// 开通账户
		UserAccount account = new UserAccount();
		account.setAmount(0L);
		account.setCreateDate(cur);
		account.setState(State.U.name());
		account.setUsername(username);
		account.setEffectiveDate(user.getEffectiveDate());
		account.setExpireDate(user.getExpireDate());
		userAccountService.save(account);

		// 账户充值 10W
		long amount = 10000000;
		userAccountService.recharge(username, FlowType.INCOME, amount, "系统充值");

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

	@Override
	public void updateUserInfo(User user) {
		Assert.notNull(user);
		String username = user.getUsername();
		Assert.hasText(username);
		User _user = selectByUsername(username);
		Assert.notNull(_user);
		if (StringUtils.hasText(user.getPassword())) {
			UserPwdSalt userPwdSalt = userPwdSaltService.selectByUsername(username);
			_user.setPassword(PwdUtil.sha256Hash(user.getPassword(), userPwdSalt.getSalt()));
		}
		if (StringUtils.hasText(user.getEmail())) {
			_user.setEmail(user.getEmail());
		}
		if (StringUtils.hasText(user.getCellphoneNumber())) {
			_user.setCellphoneNumber(user.getCellphoneNumber());
		}
		_user.setLastModifyDate(new Date());
		updateNotNull(_user);

	}

}