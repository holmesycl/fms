package com.taohj.fms.service;

import java.util.List;

import com.taohj.fms.model.TransactionFlow;

public interface TransactionFlowService extends IService<TransactionFlow> {

	/**
	 * 查询用户的交易流水
	 * 
	 * @param username
	 *            用户名
	 * @return
	 */
	List<TransactionFlow> findFlowByUsername(String username);

}
