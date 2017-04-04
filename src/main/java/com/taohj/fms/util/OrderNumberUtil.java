package com.taohj.fms.util;

import java.security.SecureRandom;
import java.util.Date;

import org.apache.commons.lang.time.DateFormatUtils;

public abstract class OrderNumberUtil {

	private static final String pattern = "yyyyMMddHHmmss";

	public static long get() {
		String orderNmuber = DateFormatUtils.format(new Date(), pattern) + (new SecureRandom().nextInt(900) + 100);
		return Long.parseLong(orderNmuber);
	}
}
