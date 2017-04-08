package com.taohj.fms.web.model;

import java.util.Date;

import org.apache.commons.lang.time.DateFormatUtils;

public class UserProductModel {

	/**
	 * 主键
	 */
	private Long userProductId;

	/**
	 * 订单编号
	 */
	private Long orderNumber;

	/**
	 * 用户名
	 */
	private String username;

	/**
	 * 理财产品ID
	 */
	private Integer productId;

	/**
	 * 理财产品名称
	 */
	private String productName;

	/**
	 * 期限类型
	 */
	private String termType;

	/**
	 * 期限类型名称
	 */
	private String termName;

	/**
	 * 金额
	 */
	private Long amount;

	/**
	 * 创建时间
	 */
	private Date createDate;

	/**
	 * 生效时间
	 */

	private Date effectiveDate;

	/**
	 * 失效时间
	 */

	private Date expireDate;

	/**
	 * 理财产品状态
	 */
	private String productState;

	private String stateDesc;

	/**
	 * 收益
	 */
	private Long income;

	/**
	 * 获取主键
	 *
	 * @return user_product_id - 主键
	 */
	public Long getUserProductId() {
		return userProductId;
	}

	/**
	 * 设置主键
	 *
	 * @param userProductId
	 *            主键
	 */
	public void setUserProductId(Long userProductId) {
		this.userProductId = userProductId;
	}

	public Long getOrderNumber() {
		if (userProductId != null) {
			orderNumber = Long.parseLong(userProductId.toString().substring(0, 17));
		}
		return orderNumber;
	}

	public void setOrderNumber(Long orderNumber) {
		this.orderNumber = orderNumber;
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
	 * 获取理财产品ID
	 *
	 * @return product_id - 理财产品ID
	 */
	public Integer getProductId() {
		return productId;
	}

	/**
	 * 设置理财产品ID
	 *
	 * @param productId
	 *            理财产品ID
	 */
	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	/**
	 * 获取理财产品名称
	 * 
	 * @return
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * 设置理财产品名称
	 * 
	 * @param productName
	 *            理财产品名称
	 */
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
	 * 获取理财产品状态
	 * 
	 * @return 理财产品状态
	 */
	public String getProductState() {
		Date cur = new Date();
		if (cur.before(getEffectiveDate())) {
			this.productState = "1";
		} else if (cur.after(getEffectiveDate()) && cur.before(getExpireDate())) {
			this.productState = "2";
		} else if (cur.after(getExpireDate())) {
			this.productState = "3";
		}
		return this.productState;
	}

	/**
	 * 设置理财产品状态
	 * 
	 * @param productState
	 *            理财产品状态
	 */
	public void setProductState(String productState) {
		this.productState = productState;
	}

	public String getStateDesc() {
		Date cur = new Date();
		String pattern = "yyyy-MM-dd";
		if (cur.before(getEffectiveDate())) {
			this.stateDesc = "即将产生收益：" + DateFormatUtils.format(getEffectiveDate(), pattern);
		} else if (cur.after(getEffectiveDate()) && cur.before(getExpireDate())) {
			this.stateDesc = "开始产生收益：" + DateFormatUtils.format(getEffectiveDate(), pattern);
		} else if (cur.after(getExpireDate())) {
			this.stateDesc = "到期停止收益：" + DateFormatUtils.format(getExpireDate(), pattern);
		}
		return this.stateDesc;
	}

	public void setStateDesc(String stateDesc) {
		this.stateDesc = stateDesc;
	}

	public Long getIncome() {
		return income;
	}

	public void setIncome(Long income) {
		this.income = income;
	}

	public String getTermType() {
		return termType;
	}

	public void setTermType(String termType) {
		this.termType = termType;
	}

	public String getTermName() {
		if ("1".equals(getTermType())) {
			termName = "定期";
		} else if ("2".equals(getTermType())) {
			termName = "活期";
		}
		return termName;
	}

	public void setTermName(String termName) {
		this.termName = termName;
	}

	/**
	 * 到期时间
	 */
	private String endDate;

	private String pedeemLimit;

	private String canPedeem;

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getPedeemLimit() {
		return pedeemLimit;
	}

	public void setPedeemLimit(String pedeemLimit) {
		this.pedeemLimit = pedeemLimit;
	}

	public String getCanPedeem() {
		return canPedeem;
	}

	public void setCanPedeem(String canPedeem) {
		this.canPedeem = canPedeem;
	}

}
