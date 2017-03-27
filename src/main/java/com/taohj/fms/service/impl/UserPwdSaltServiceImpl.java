package com.taohj.fms.service.impl;

import java.util.Date;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.taohj.fms.model.UserPwdSalt;
import com.taohj.fms.service.UserPwdSaltService;
import com.taohj.fms.util.SaltUtil;
import com.taohj.fms.util.State;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

@Service
public class UserPwdSaltServiceImpl extends BaseService<UserPwdSalt> implements UserPwdSaltService {

	@Override
	public UserPwdSalt createUserPwdSalt(String username) {
		Assert.notNull(username, "username不能为空.");
		UserPwdSalt userPwdSalt = new UserPwdSalt();
		userPwdSalt.setUsername(username);
		userPwdSalt.setSalt(SaltUtil.sysdateSalt());
		userPwdSalt.setCreateDate(new Date());
		userPwdSalt.setState(State.U.name());
		this.save(userPwdSalt);
		return userPwdSalt;
	}

	@Override
	public UserPwdSalt selectByUsername(String username) {
		Example example = new Example(UserPwdSalt.class);
		Criteria criteria = example.createCriteria();
		criteria.andEqualTo("state", State.U.name());
		criteria.andEqualTo("username", username);
		return selectOne(example);
	}

}
