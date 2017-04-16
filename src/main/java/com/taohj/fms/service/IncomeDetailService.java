package com.taohj.fms.service;

import java.util.Date;
import java.util.List;

import com.taohj.fms.model.IncomeDetail;
import com.taohj.fms.web.model.IncomeDetailModel;

public interface IncomeDetailService extends IService<IncomeDetail> {

	List<IncomeDetailModel> findIncomeDetailByUsernameAndProduct(String username, int productId);

	/**
	 * 查询用户某个理财产品的总收益
	 * 
	 * @param username
	 * @param productId
	 */
	Long findIncomeByUsernameAndProduct(String username, int productId);

	/**
	 * 查询某个理财产品的昨日收益
	 * 
	 * @param username
	 * @param productId
	 * @return
	 */
	Long findYesterdayIncomeByUsernameAndProduct(String username, int productId);

	/**
	 * 查询某个理财产品的某一天的收益
	 * 
	 * @param username
	 * @param productId
	 * @return
	 */
	Long findIncomeByUsernameAndProduct(String username, int productId, Date date);

}
