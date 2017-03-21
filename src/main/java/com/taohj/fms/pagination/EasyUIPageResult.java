package com.taohj.fms.pagination;

import java.util.List;

public class EasyUIPageResult<T> extends SimplePageResult<T> {

	public List<T> getRows() {
		return super.getResult();
	}
}
