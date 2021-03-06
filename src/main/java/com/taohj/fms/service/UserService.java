package com.taohj.fms.service;

import com.taohj.fms.model.User;

public interface UserService extends IService<User> {

	User selectByUsername(final String username);

	User createUser(int userType, String username, String password, String email);

	/**
	 * 修改用户信息
	 * 
	 * @param user
	 */
	void updateUserInfo(User user);

}
