package com.taohj.fms.web.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class UserProductModel {

	/**
	 * 主键
	 */
	private Long userProductId;

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
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
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
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
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
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
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
			return "未生效";
		} else if (cur.after(getEffectiveDate()) && cur.before(getExpireDate())) {
			return "收益中";
		} else if (cur.after(getExpireDate())) {
			return "已过期";
		}
		return productState;
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

}
