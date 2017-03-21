package com.taohj.fms.pagination;

public class EasyUIPageCondition implements PageCondition {

	private int page;

	private int rows;

	public EasyUIPageCondition() {
		super();
	}

	public EasyUIPageCondition(int page, int rows) {
		super();
		this.page = page;
		this.rows = rows;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	@Override
	public int getPageNum() {
		return this.page;
	}

	@Override
	public void setPageNum(int pageNum) {
		this.page = pageNum;
	}

	@Override
	public int getPageSize() {
		return this.rows;
	}

	@Override
	public void setPageSize(int pageSize) {
		this.rows = pageSize;
	}

}
