package com.taohj.fms.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.taohj.fms.model.TransactionFlow;
import com.taohj.fms.service.TransactionFlowService;
import com.taohj.fms.util.State;

import tk.mybatis.mapper.entity.Example;

@Service("transactionFlowService")
public class TransactionFlowServiceImpl extends BaseService<TransactionFlow> implements TransactionFlowService {

	@Override
	public List<TransactionFlow> findFlowByUsername(String username) {
		Example example = new Example(TransactionFlow.class);
		example.createCriteria()
		.andEqualTo("state", State.U.name())
		.andEqualTo("username", username);
		example.setOrderByClause("create_date desc");
		List<TransactionFlow> flows = selectByExample(example);
		return flows;
	}

}
