package com.taohj.fms.service;

import com.taohj.fms.model.UserAccount;
import com.taohj.fms.util.FlowType;

public interface UserAccountService extends IService<UserAccount> {

	/**
	 * 给用户充值
	 * 
	 * @param username
	 * @param amount
	 */
	void recharge(String username, FlowType flowTyp, long amount, String channel);

	/**
	 * 
	 * @param username
	 * @return
	 */
	public UserAccount findAccountByUsername(final String username);

}
