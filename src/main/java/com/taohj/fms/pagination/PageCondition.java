package com.taohj.fms.pagination;

/**
 * 分页条件
 * 
 * @author yecl
 *
 */
public interface PageCondition {

	int getPageNum();

	void setPageNum(int pageNum);

	int getPageSize();

	void setPageSize(int pageSize);
}
