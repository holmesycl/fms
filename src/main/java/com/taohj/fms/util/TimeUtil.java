package com.taohj.fms.util;

import java.util.Calendar;
import java.util.Date;

public abstract class TimeUtil {

	public static class DateContainer {
		private Date date;

		public DateContainer(Date date) {
			this.date = date;
		}

		public Date start() {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			calendar.set(Calendar.HOUR_OF_DAY, 0);
			calendar.set(Calendar.MINUTE, 0);
			calendar.set(Calendar.SECOND, 0);
			return calendar.getTime();
		}

		public Date now() {
			return date;
		}

		public Date end() {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			calendar.set(Calendar.HOUR_OF_DAY, 23);
			calendar.set(Calendar.MINUTE, 59);
			calendar.set(Calendar.SECOND, 59);
			return calendar.getTime();
		}
	}
	
	/**
	 * 
	 * @param days
	 * @return
	 */
	public static DateContainer date(Date date) {
		return new DateContainer(date);
	}

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
	public static DateContainer plus(int days) {
		return plus(new Date(), days);
	}

	/**
	 * 
	 * @param date
	 * @param days
	 * @return
	 */
	public static DateContainer plus(Date date, int days) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, days);
		return new DateContainer(calendar.getTime());
	}

}
