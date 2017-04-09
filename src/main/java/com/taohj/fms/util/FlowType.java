package com.taohj.fms.util;

public enum FlowType {

	INCOME("1"), PAY("2");

	private String value;

	private FlowType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
