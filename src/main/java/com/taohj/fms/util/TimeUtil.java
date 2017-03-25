package com.taohj.fms.util;

import java.util.Calendar;
import java.util.Date;

public abstract class TimeUtil {

	public static Date expireDate() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(2099, 11, 31, 23, 59, 59);
		return calendar.getTime();
	}

}
