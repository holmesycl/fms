package com.taohj.fms.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Table(name = "financial_product")
public class FinancialProduct {
	/**
	 * 产品ID
	 */
	@Id
	@Column(name = "product_id")
	private Integer productId;

	/**
	 * 产品名称
	 */
	@Column(name = "product_name")
	private String productName;

	/**
	 * 产品描述
	 */
	@Column(name = "product_desc")
	private String productDesc;

	/**
	 * 创建时间
	 */
	@Column(name = "create_date")
	private Date createDate;

	/**
	 * 最后一次修改时间
	 */
	@Column(name = "last_modify_date")
	private Date lastModifyDate;

	/**
	 * 生效时间
	 */
	@Column(name = "effective_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date effectiveDate;

	/**
	 * 失效时间
	 */
	@Column(name = "expire_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date expireDate;

	/**
	 * 发售开始时间
	 */
	@Column(name = "sale_start_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date saleStartDate;

	/**
	 * 发售截止时间
	 */
	@Column(name = "sale_end_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date saleEndDate;

	/**
	 * 产品期限（天）
	 */
	@Column(name = "product_term")
	private Integer productTerm;

	/**
	 * 起始限额
	 */
	@Column(name = "limit_start_amount")
	private Long limitStartAmount;

	/**
	 * 最大限额
	 */
	@Column(name = "limit_end_amount")
	private Long limitEndAmount;

	/**
	 * 产品类型
	 */
	@Column(name = "product_type")
	private String productType;

	/**
	 * 风险等级
	 */
	@Column(name = "risk_level")
	private String riskLevel;

	/**
	 * 预期收益率（年）
	 */
	@Column(name = "expect_rate")
	private Float expectRate;

	/**
	 * 状态
	 */
	private String state;

	/**
	 * 备注
	 */
	private String remark;

	/**
	 * 获取产品ID
	 *
	 * @return product_id - 产品ID
	 */
	public Integer getProductId() {
		return productId;
	}

	/**
	 * 设置产品ID
	 *
	 * @param productId
	 *            产品ID
	 */
	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	/**
	 * 获取产品名称
	 *
	 * @return product_name - 产品名称
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * 设置产品名称
	 *
	 * @param productName
	 *            产品名称
	 */
	public void setProductName(String productName) {
		this.productName = productName == null ? null : productName.trim();
	}

	/**
	 * 获取产品描述
	 *
	 * @return product_desc - 产品描述
	 */
	public String getProductDesc() {
		return productDesc;
	}

	/**
	 * 设置产品描述
	 *
	 * @param productDesc
	 *            产品描述
	 */
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc == null ? null : productDesc.trim();
	}

	/**
	 * 获取创建时间
	 *
	 * @return create_date - 创建时间
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * 设置创建时间
	 *
	 * @param createDate
	 *            创建时间
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * 获取最后一次修改时间
	 *
	 * @return last_modify_date - 最后一次修改时间
	 */
	public Date getLastModifyDate() {
		return lastModifyDate;
	}

	/**
	 * 设置最后一次修改时间
	 *
	 * @param lastModifyDate
	 *            最后一次修改时间
	 */
	public void setLastModifyDate(Date lastModifyDate) {
		this.lastModifyDate = lastModifyDate;
	}

	/**
	 * 获取生效时间
	 *
	 * @return effective_date - 生效时间
	 */
	public Date getEffectiveDate() {
		return effectiveDate;
	}

	/**
	 * 设置生效时间
	 *
	 * @param effectiveDate
	 *            生效时间
	 */
	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	/**
	 * 获取失效时间
	 *
	 * @return expire_date - 失效时间
	 */
	public Date getExpireDate() {
		return expireDate;
	}

	/**
	 * 设置失效时间
	 *
	 * @param expireDate
	 *            失效时间
	 */
	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

	/**
	 * 获取发售开始时间
	 *
	 * @return sale_start_date - 发售开始时间
	 */
	public Date getSaleStartDate() {
		return saleStartDate;
	}

	/**
	 * 设置发售开始时间
	 *
	 * @param saleStartDate
	 *            发售开始时间
	 */
	public void setSaleStartDate(Date saleStartDate) {
		this.saleStartDate = saleStartDate;
	}

	/**
	 * 获取发售截止时间
	 *
	 * @return sale_end_date - 发售截止时间
	 */
	public Date getSaleEndDate() {
		return saleEndDate;
	}

	/**
	 * 设置发售截止时间
	 *
	 * @param saleEndDate
	 *            发售截止时间
	 */
	public void setSaleEndDate(Date saleEndDate) {
		this.saleEndDate = saleEndDate;
	}

	/**
	 * 获取产品期限（天）
	 *
	 * @return product_term - 产品期限（天）
	 */
	public Integer getProductTerm() {
		return productTerm;
	}

	/**
	 * 设置产品期限（天）
	 *
	 * @param productTerm
	 *            产品期限（天）
	 */
	public void setProductTerm(Integer productTerm) {
		this.productTerm = productTerm;
	}

	/**
	 * 获取起始限额
	 *
	 * @return limit_start_amount - 起始限额
	 */
	public Long getLimitStartAmount() {
		return limitStartAmount;
	}

	/**
	 * 设置起始限额
	 *
	 * @param limitStartAmount
	 *            起始限额
	 */
	public void setLimitStartAmount(Long limitStartAmount) {
		this.limitStartAmount = limitStartAmount;
	}

	/**
	 * 获取最大限额
	 *
	 * @return limit_end_amount - 最大限额
	 */
	public Long getLimitEndAmount() {
		return limitEndAmount;
	}

	/**
	 * 设置最大限额
	 *
	 * @param limitEndAmount
	 *            最大限额
	 */
	public void setLimitEndAmount(Long limitEndAmount) {
		this.limitEndAmount = limitEndAmount;
	}

	/**
	 * 获取产品类型
	 *
	 * @return product_type - 产品类型
	 */
	public String getProductType() {
		return productType;
	}

	/**
	 * 设置产品类型
	 *
	 * @param productType
	 *            产品类型
	 */
	public void setProductType(String productType) {
		this.productType = productType == null ? null : productType.trim();
	}

	/**
	 * 获取风险等级
	 *
	 * @return risk_level - 风险等级
	 */
	public String getRiskLevel() {
		return riskLevel;
	}

	/**
	 * 设置风险等级
	 *
	 * @param riskLevel
	 *            风险等级
	 */
	public void setRiskLevel(String riskLevel) {
		this.riskLevel = riskLevel == null ? null : riskLevel.trim();
	}

	/**
	 * 获取预期收益率（年）
	 *
	 * @return expect_rate - 预期收益率（年）
	 */
	public Float getExpectRate() {
		return expectRate;
	}

	/**
	 * 设置预期收益率（年）
	 *
	 * @param expectRate
	 *            预期收益率（年）
	 */
	public void setExpectRate(Float expectRate) {
		this.expectRate = expectRate;
	}

	/**
	 * 获取状态
	 *
	 * @return state - 状态
	 */
	public String getState() {
		return state;
	}

	/**
	 * 设置状态
	 *
	 * @param state
	 *            状态
	 */
	public void setState(String state) {
		this.state = state == null ? null : state.trim();
	}

	/**
	 * 获取备注
	 *
	 * @return remark - 备注
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * 设置备注
	 *
	 * @param remark
	 *            备注
	 */
	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}
}