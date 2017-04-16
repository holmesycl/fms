package com.taohj.fms.schedule;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.taohj.fms.model.FinancialProduct;
import com.taohj.fms.model.IncomeDetail;
import com.taohj.fms.model.ProductRate;
import com.taohj.fms.model.UserProduct;
import com.taohj.fms.service.FinancialProductService;
import com.taohj.fms.service.IncomeDetailService;
import com.taohj.fms.service.ProductRateService;
import com.taohj.fms.service.UserAccountService;
import com.taohj.fms.service.UserProductService;
import com.taohj.fms.util.FlowType;
import com.taohj.fms.util.State;
import com.taohj.fms.util.TimeUtil;

/**
 * 收益调度
 * 
 * @author holme
 *
 */
@Service
@Transactional
public class IncomeSchedule implements Schedule {

	@Autowired
	private IncomeDetailService incomeDetailService;

	@Autowired
	private ProductRateService productRateService;

	@Autowired
	private UserProductService userProductService;

	@Autowired
	private UserAccountService userAccountService;

	@Autowired
	private FinancialProductService financialProductService;

	@Scheduled(cron = "0 0 20 * * ?")
	@Override
	public void execute() {
		List<ProductRate> productRates = productRateService.findProductTodayRate();
		Map<Integer, Float> rateMap = new HashMap<Integer, Float>();
		if (!CollectionUtils.isEmpty(productRates)) {
			for (ProductRate productRate : productRates) {
				rateMap.put(productRate.getProductId(), productRate.getRate());
			}
		}

		List<UserProduct> userProducts = userProductService.findExpireDateGreaterNowUserProduct();
		if (!CollectionUtils.isEmpty(userProducts)) {
			for (UserProduct userProduct : userProducts) {
				Integer productId = userProduct.getProductId();
				long amount = userProduct.getAmount();
				float rate = rateMap.get(productId);
				long income = (long) (amount * rate);
				IncomeDetail incomeDetail = new IncomeDetail();
				incomeDetail.setProductId(productId);
				incomeDetail.setState(State.U.name());
				incomeDetail.setAmount(income);
				incomeDetail.setUsername(userProduct.getUsername());
				incomeDetail.setType(income > 0 ? "1" : "2");
				incomeDetail.setCreateDate(new Date());
				incomeDetailService.save(incomeDetail);

				userProduct.setAmount(userProduct.getAmount() + income);
				userProductService.updateNotNull(userProduct);

				// 计算收益
				if (userProduct.getExpireDate().before(TimeUtil.plus(1).start())) {
					FinancialProduct product = financialProductService.selectByKey(productId);
					userAccountService.recharge(userProduct.getUsername(), FlowType.INCOME, userProduct.getAmount(),
							"理财产品【" + product.getProductName() + "】所得收益。");
				}
			}

		}
	}
}
