package com.taohj.fms.web.model;

import java.io.Serializable;
import java.util.Date;

public class OrderModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3950351332838984202L;

	private long orderNumber;

	private String businessType;

	private String businessName;

	private int productId;

	private String productName;

	private Date createDate;

	private long amount;

	private Date effectiveDate;

	private Date expireDate;

	public long getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(long orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getBusinessType() {
		return businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	public String getBusinessName() {
		if ("1".equals(businessType)) {
			businessName = "购买理财产品";
		} else if ("2".equals(businessType)) {
			businessName = "赎回理财产品";
		}
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public Date getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public Date getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

}
