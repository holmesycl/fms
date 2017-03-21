package com.taohj.fms.service;

import com.taohj.fms.model.User;
import com.taohj.fms.pagination.PageCondition;
import com.taohj.fms.pagination.PageResult;

public interface UserService extends IService<User> {

	User saveUser(User user);

	PageResult<User> selectAll(User user, PageCondition pageCondition);

}
