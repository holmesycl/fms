package com.taohj.fms.service;

import java.util.List;

import com.taohj.fms.model.UserProduct;
import com.taohj.fms.web.PageResult;
import com.taohj.fms.web.model.UserProductModel;

public interface UserProductService extends IService<UserProduct> {

	/**
	 * 分页查询用户已购买的理财产品
	 * 
	 * @param username
	 * @param page
	 * @param rows
	 * @return
	 */
	PageResult<UserProductModel> findProduct(String username, int page, int rows);

	/**
	 * 
	 * @param userProductId
	 * @return
	 */
	UserProductModel findModelByUsernameAndUserProduct(String username, long userProductId);

	/**
	 * 
	 * @param userProductId
	 * @return
	 */
	List<UserProduct> findByUsernameAndProduct(String username, long productId, int effectiveType);

	/**
	 * 查询失效时间大于今天的用户产品
	 * 
	 * @param username
	 *            用户名
	 * @param productId
	 *            产品ID
	 * @return 用户产品
	 */
	List<UserProduct> findExpireDateGreaterTodayByUsernameAndProduct(String username, int productId);

	/**
	 * 获取失效时间大于当前时间的用户产品.
	 * 
	 * @return
	 */
	List<UserProduct> findExpireDateGreaterNowUserProduct();

}
