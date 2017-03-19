package com.taohj.fms.util;

public abstract class SaltUtil {

	public static String sysdateSalt() {
		return String.valueOf(System.currentTimeMillis());
	}

}
