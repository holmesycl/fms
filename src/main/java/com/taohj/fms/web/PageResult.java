package com.taohj.fms.web;

import java.util.List;

import com.github.pagehelper.Page;

/**
 * 分页查询结果
 * 
 * @author yecl
 *
 * @param <T>
 */
public class PageResult<T> {

	private long total;

	private List<T> rows;

	public long getTotal() {
		return this.total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	public PageResult() {
	}

	public PageResult(long total, List<T> rows) {
		this.total = total;
		this.rows = rows;
	}

	public PageResult(Page<T> page) {
		this.total = page.getTotal();
		this.rows = page.getResult();
	}
}
