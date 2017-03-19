package com.taohj.fms.service;

import java.util.List;

import com.taohj.fms.model.User;
import com.taohj.fms.web.Pagination;

public interface UserService extends IService<User> {

	User saveUser(User user);
	
	Pagination<User> selectAll(int page, int rows);

}
