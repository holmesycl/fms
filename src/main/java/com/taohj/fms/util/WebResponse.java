package com.taohj.fms.util;

import java.io.Serializable;

/**
 * Web层响应
 * 
 * @author holme
 *
 */
public class WebResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4936087775964900111L;

	public enum ResponceType {

		ERROR("error", "错误"), INFO("info", "提示"), WARNING("warning", "警告");

		private String name;
		private String title;

		ResponceType(String name, String title) {
			this.name = name;
			this.title = title;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

	}

	private String title;

	private String type;

	private int code;

	private String msg;

	public static WebResponse error(String msg) {
		return new WebResponse(ResponceType.ERROR, 0, msg);
	}

	public static WebResponse info(String msg) {
		return new WebResponse(ResponceType.INFO, 0, msg);
	}

	public static WebResponse warning(String msg) {
		return new WebResponse(ResponceType.WARNING, 0, msg);
	}

	public WebResponse() {
	}

	public WebResponse(String title, String type, int code, String msg) {
		this.title = title;
		this.type = type;
		this.code = code;
		this.msg = msg;
	}

	public WebResponse(ResponceType responceType, int code, String msg) {
		this.title = responceType.getTitle();
		this.type = responceType.getName();
		this.code = code;
		this.msg = msg;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
