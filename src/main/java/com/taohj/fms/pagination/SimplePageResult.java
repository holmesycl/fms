package com.taohj.fms.pagination;

import java.util.List;

import com.github.pagehelper.Page;

public class SimplePageResult<T> implements PageResult<T> {

	private long total;

	private List<T> result;

	@Override
	public long getTotal() {
		return this.total;
	}

	@Override
	public void setTotal(long total) {
		this.total = total;
	}

	@Override
	public List<T> getResult() {
		return this.result;
	}

	@Override
	public void setResult(List<T> result) {
		this.result = result;
	}

	public static <T> PageResult<T> create(Page<T> page) {
		SimplePageResult<T> pageResult = new SimplePageResult<T>();
		pageResult.setTotal(page.getTotal());
		pageResult.setResult(page.getResult());
		return pageResult;
	}

}
