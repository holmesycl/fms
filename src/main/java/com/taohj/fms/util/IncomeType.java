package com.taohj.fms.util;

public enum IncomeType {
	/**
	 * 盈利
	 */
	PROFIT("1", "盈利"),
	/**
	 * 亏损
	 */
	LOSS("2", "亏损");

	private String type;

	private String name;

	public static IncomeType forType(String type) {
		if (PROFIT.getType().equals(type)) {
			return PROFIT;
		} else if (LOSS.getType().equals(type)) {
			return LOSS;
		}
		return null;
	}

	private IncomeType(String type, String name) {
		this.type = type;
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
