package com.taohj.fms.web;

import java.util.List;

public class Pagination<T> {

	private long total;

	private List<T> rows;

	public long getTotal() {
		return total;
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

	public Pagination(long total, List<T> rows) {
		super();
		this.total = total;
		this.rows = rows;
	}

	public Pagination() {
		super();
		// TODO Auto-generated constructor stub
	}

}
