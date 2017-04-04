package com.taohj.fms.util;

import java.util.Calendar;
import java.util.Date;

public abstract class TimeUtil {

	public static Date expireDate() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(2099, 11, 31, 23, 59, 59);
		return calendar.getTime();
	}

	/**
	 * 
	 * @param days
	 * @return
	 */
	public static Date plus(int days) {
		return plus(new Date(), days);
	}

	/**
	 * 
	 * @param date
	 * @param days
	 * @return
	 */
	public static Date plus(Date date, int days) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, days);
		return calendar.getTime();
	}

}
