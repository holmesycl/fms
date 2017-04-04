package com.taohj.fms.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "user_product")
public class UserProduct {
    /**
     * 主键
     */
    @Id
    @Column(name = "user_product_id")
    private Long userProductId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 理财产品ID
     */
    @Column(name = "product_id")
    private Integer productId;

    /**
     * 金额（分）
     */
    private Long amount;

    /**
     * 创建时间
     */
    @Column(name = "create_date")
    private Date createDate;

    /**
     * 生效时间
     */
    @Column(name = "effective_date")
    private Date effectiveDate;

    /**
     * 失效时间
     */
    @Column(name = "expire_date")
    private Date expireDate;

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
     * @return user_product_id - 主键
     */
    public Long getUserProductId() {
        return userProductId;
    }

    /**
     * 设置主键
     *
     * @param userProductId 主键
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
     * @param username 用户名
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
     * @param productId 理财产品ID
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
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
     * @param amount 金额（分）
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
     * @param createDate 创建时间
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
     * @param effectiveDate 生效时间
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
     * @param expireDate 失效时间
     */
    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
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
     * @param state 状态
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
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}