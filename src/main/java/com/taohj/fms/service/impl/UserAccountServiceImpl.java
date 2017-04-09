package com.taohj.fms.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import com.taohj.fms.model.TransactionFlow;
import com.taohj.fms.model.UserAccount;
import com.taohj.fms.service.TransactionFlowService;
import com.taohj.fms.service.UserAccountService;
import com.taohj.fms.util.EffectiveExample;
import com.taohj.fms.util.FlowType;
import com.taohj.fms.util.State;

import tk.mybatis.mapper.entity.Example;

@Service("userAccountService")
public class UserAccountServiceImpl extends BaseService<UserAccount> implements UserAccountService {

	@Autowired
	private TransactionFlowService transactionFlowService;

	@Override
	public void recharge(String username, FlowType flowTyp, long amount, String channel) {
		UserAccount account = findAccountByUsername(username);
		if (FlowType.INCOME == flowTyp) {
			account.setAmount(account.getAmount() + amount);
		} else if (FlowType.PAY == flowTyp) {
			account.setAmount(account.getAmount() - amount);
		}
		updateNotNull(account);

		// 记录交易流水
		TransactionFlow flow = new TransactionFlow();
		flow.setAccountId(account.getAccountId());
		flow.setAmount(amount);
		flow.setChannel(channel);
		flow.setCreateDate(new Date());
		flow.setFlowType(flowTyp.getValue());
		flow.setState(State.U.name());
		flow.setUsername(username);
		transactionFlowService.save(flow);
	}

	@Override
	public UserAccount findAccountByUsername(final String username) {
		Example example = new EffectiveExample(UserAccount.class) {

			@Override
			protected void fillCriteria(Criteria criteria) {
				criteria.andEqualTo("username", username);
			}
		};
		List<UserAccount> userAccounts = selectByExample(example);
		Assert.state(!CollectionUtils.isEmpty(userAccounts) && userAccounts.size() == 1, "根据用户名[" + username + "]获取用户账户异常.");
		return userAccounts.get(0);
	}

}
