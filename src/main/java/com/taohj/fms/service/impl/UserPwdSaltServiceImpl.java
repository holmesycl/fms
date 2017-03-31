package com.taohj.fms.service.impl;

import java.util.Date;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.taohj.fms.model.UserPwdSalt;
import com.taohj.fms.model.UserRole;
import com.taohj.fms.service.UserPwdSaltService;
import com.taohj.fms.util.EffectiveExample;
import com.taohj.fms.util.SaltUtil;
import com.taohj.fms.util.State;
import com.taohj.fms.util.TimeUtil;

import tk.mybatis.mapper.entity.Example;

@Service
public class UserPwdSaltServiceImpl extends BaseService<UserPwdSalt> implements UserPwdSaltService {

	@Override
	public UserPwdSalt createUserPwdSalt(String username) {
		Assert.notNull(username, "username不能为空.");
		UserPwdSalt userPwdSalt = new UserPwdSalt();
		userPwdSalt.setUsername(username);
		userPwdSalt.setSalt(SaltUtil.sysdateSalt());
		Date cur = new Date();
		userPwdSalt.setCreateDate(cur);
		userPwdSalt.setEffectiveDate(cur);
		userPwdSalt.setExpireDate(TimeUtil.expireDate());
		userPwdSalt.setState(State.U.name());
		this.save(userPwdSalt);
		return userPwdSalt;
	}

	@Override
	public UserPwdSalt selectByUsername(final String username) {
		Example example = new EffectiveExample(UserRole.class) {

			@Override
			protected void fillCriteria(Criteria criteria) {
				criteria.andEqualTo("username", username);
			}
		};
		return selectOne(example);
	}

}
