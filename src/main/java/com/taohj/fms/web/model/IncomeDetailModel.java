package com.taohj.fms.web.model;

import java.io.Serializable;
import java.util.Date;

import com.taohj.fms.util.IncomeType;

public class IncomeDetailModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3916302264912035529L;

	/**
	 * 主键
	 */
	private Integer id;

	/**
	 * 用户名
	 */
	private String username;

	/**
	 * 收益类型。1 - 收益；2 - 亏损
	 */
	private String type;

	private String typeName;

	/**
	 * 产品
	 */
	private Integer productId;

	/**
	 * 产品名称
	 */
	private String productName;

	/**
	 * 金额（分）
	 */
	private Long amount;

	/**
	 * 创建时间
	 */
	private Date createDate;

	/**
	 * 状态
	 */
	private String state;

	/**
	 * 备注
	 */
	private String remark;

	/**
	 * 获取主键
	 *
	 * @return id - 主键
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 设置主键
	 *
	 * @param id
	 *            主键
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 获取用户名
	 *
	 * @return username - 用户名
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * 设置用户名
	 *
	 * @param username
	 *            用户名
	 */
	public void setUsername(String username) {
		this.username = username == null ? null : username.trim();
	}

	/**
	 * 获取收益类型。1 - 收益；2 - 亏损
	 *
	 * @return type - 收益类型。1 - 收益；2 - 亏损
	 */
	public String getType() {
		return type;
	}

	/**
	 * 设置收益类型。1 - 收益；2 - 亏损
	 *
	 * @param type
	 *            收益类型。1 - 收益；2 - 亏损
	 */
	public void setType(String type) {
		this.type = type == null ? null : type.trim();
	}

	/**
	 * 获取产品
	 *
	 * @return product_id - 产品
	 */
	public Integer getProductId() {
		return productId;
	}

	/**
	 * 设置产品
	 *
	 * @param productId
	 *            产品
	 */
	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * 获取金额（分）
	 *
	 * @return amount - 金额（分）
	 */
	public Long getAmount() {
		return amount;
	}

	/**
	 * 设置金额（分）
	 *
	 * @param amount
	 *            金额（分）
	 */
	public void setAmount(Long amount) {
		this.amount = amount;
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

	public String getTypeName() {
		this.typeName = IncomeType.forType(type).getName();
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

}
