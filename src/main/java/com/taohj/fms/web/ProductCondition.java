package com.taohj.fms.web;

/**
 * 封装产品查询条件
 * 
 * @author holme
 *
 */
public class ProductCondition {

	/**
	 * 产品ID
	 */
	private Integer productId;

	/**
	 * 产品名称
	 */
	private String productName;

	/**
	 * 期限类型
	 */
	private String termType;

	/**
	 * 产品类型
	 */
	private String productType;

	/**
	 * 风险等级
	 */
	private String riskLevel;

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getRiskLevel() {
		return riskLevel;
	}

	public void setRiskLevel(String riskLevel) {
		this.riskLevel = riskLevel;
	}

	public String getTermType() {
		return termType;
	}

	public void setTermType(String termType) {
		this.termType = termType;
	}

}
