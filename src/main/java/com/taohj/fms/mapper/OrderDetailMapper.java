package com.taohj.fms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.taohj.fms.model.OrderDetail;
import tk.mybatis.mapper.common.Mapper;

public interface OrderDetailMapper extends Mapper<OrderDetail> {
	
	@Select("select product_id from order_detail t group by product_id order by count(product_id) desc")
	List<Integer> selectProductGroupByProductIdAndOrderByCount();
}