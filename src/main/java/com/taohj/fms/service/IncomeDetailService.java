package com.taohj.fms.service;

import java.util.List;

import com.taohj.fms.model.IncomeDetail;
import com.taohj.fms.web.model.IncomeDetailModel;

public interface IncomeDetailService extends IService<IncomeDetail> {

	List<IncomeDetailModel> findIncomeDetailByUsernameAndProduct(String username, int productId);

}
