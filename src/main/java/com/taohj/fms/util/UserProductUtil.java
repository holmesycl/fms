package com.taohj.fms.util;

public abstract class UserProductUtil {
	public static long getId(long orderNumber, int index) {
		return Long.parseLong(orderNumber + "" + index);
	}
}
