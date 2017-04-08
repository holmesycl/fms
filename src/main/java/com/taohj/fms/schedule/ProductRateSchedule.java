package com.taohj.fms.schedule;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.taohj.fms.model.FinancialProduct;
import com.taohj.fms.model.ProductRate;
import com.taohj.fms.service.FinancialProductService;
import com.taohj.fms.service.ProductRateService;
import com.taohj.fms.util.State;
import com.taohj.fms.util.TimeUtil;

@Component
public class ProductRateSchedule implements Schedule {

	@Autowired
	private ProductRateService productRateService;

	@Autowired
	private FinancialProductService financialProductService;

	@Scheduled(cron = "0 0 18 * * ?")
	@Override
	public void execute() {
		List<FinancialProduct> products = financialProductService.findAllProduct();
		if (!CollectionUtils.isEmpty(products)) {
			for (FinancialProduct product : products) {
				Calendar calendar = Calendar.getInstance();
				int dayOfYear = calendar.getActualMaximum(Calendar.DAY_OF_YEAR);
				float rate = product.getExpectRate() / dayOfYear;
				// 定期
				if ("2".equals(product.getTermType())) {
					String riskLevel = product.getRiskLevel();
					int raw = 0;
					if ("R1".equals(riskLevel)) {
						raw = 1;
					} else if ("R2".equals(riskLevel)) {
						raw = 2;
					} else if ("R3".equals(riskLevel)) {
						raw = 3;
					} else if ("R4".equals(riskLevel)) {
						raw = 4;
					} else if ("R5".equals(riskLevel)) {
						raw = 5;
					}
					rate = (float) (((Math.random() * raw) * 2 - raw) / 100 + rate);
				}
				ProductRate productRate = new ProductRate();
				Date cur = new Date();
				productRate.setCteateDate(cur);
				productRate.setEffectiveDate(TimeUtil.plus(0).start());
				productRate.setExpireDate(TimeUtil.plus(0).end());
				productRate.setProductId(product.getProductId());
				productRate.setRate(rate);
				productRate.setState(State.U.name());
				productRateService.save(productRate);
			}
		}
	}
}
