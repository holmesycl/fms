package com.taohj.fms.service;

import com.taohj.fms.model.UserPwdSalt;

public interface UserPwdSaltService extends IService<UserPwdSalt> {

	UserPwdSalt createUserPwdSalt(String username);

}
