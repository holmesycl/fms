package com.taohj.fms.service;

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
	UserProductModel findProduct(long userProductId);

}
