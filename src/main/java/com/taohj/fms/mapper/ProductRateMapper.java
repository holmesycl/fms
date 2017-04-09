package com.taohj.fms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.taohj.fms.model.ProductRate;
import tk.mybatis.mapper.common.Mapper;

public interface ProductRateMapper extends Mapper<ProductRate> {
	
	@Select("SELECT DISTINCT product_id FROM product_rate WHERE state = 'U' ORDER BY rate DESC")
	List<Integer> selectProductOrderByRate();
}