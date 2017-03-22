package com.taohj.fms.service.impl;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.taohj.fms.model.UserPwdSalt;
import com.taohj.fms.service.UserPwdSaltService;
import com.taohj.fms.util.SaltUtil;
import com.taohj.fms.util.State;

@Service
public class UserPwdSaltServiceImpl extends BaseService<UserPwdSalt> implements UserPwdSaltService {

	@Override
	public UserPwdSalt createUserPwdSalt(String username) {
		UserPwdSalt userPwdSalt = new UserPwdSalt();
		userPwdSalt.setUsername(username);
		userPwdSalt.setSalt(SaltUtil.sysdateSalt());
		userPwdSalt.setCreateDate(new Date());
		userPwdSalt.setUsername(State.U.name());
		save(userPwdSalt);
		return userPwdSalt;
	}

}
