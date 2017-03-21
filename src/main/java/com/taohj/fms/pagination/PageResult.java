package com.taohj.fms.pagination;

import java.util.List;

/**
 * 分页查询结果
 * 
 * @author yecl
 *
 * @param <T>
 */
public interface PageResult<T> {

	public long getTotal();

	public void setTotal(long total);

	public List<T> getResult();

	public void setResult(List<T> result);
}
