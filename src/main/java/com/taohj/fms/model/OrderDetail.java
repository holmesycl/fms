package com.taohj.fms.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "order_detail")
public class OrderDetail {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 订单流水号
     */
    @Column(name = "order_number")
    private Long orderNumber;

    @Column(name = "user_product_id")
    private Long userProductId;

    /**
     * 理财产品ID
     */
    @Column(name = "product_id")
    private Integer productId;

    /**
     * 购买金额（分）
     */
    private Long amount;

    /**
     * 创建时间
     */
    @Column(name = "create_date")
    private Date createDate;

    /**
     * 产品生效时间
     */
    @Column(name = "effective_date")
    private Date effectiveDate;

    /**
     * 产品失效时间
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
    private byte[] remark;

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
     * @param id 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取订单流水号
     *
     * @return order_number - 订单流水号
     */
    public Long getOrderNumber() {
        return orderNumber;
    }

    /**
     * 设置订单流水号
     *
     * @param orderNumber 订单流水号
     */
    public void setOrderNumber(Long orderNumber) {
        this.orderNumber = orderNumber;
    }

    /**
     * @return user_product_id
     */
    public Long getUserProductId() {
        return userProductId;
    }

    /**
     * @param userProductId
     */
    public void setUserProductId(Long userProductId) {
        this.userProductId = userProductId;
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
     * 获取购买金额（分）
     *
     * @return amount - 购买金额（分）
     */
    public Long getAmount() {
        return amount;
    }

    /**
     * 设置购买金额（分）
     *
     * @param amount 购买金额（分）
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
     * 获取产品生效时间
     *
     * @return effective_date - 产品生效时间
     */
    public Date getEffectiveDate() {
        return effectiveDate;
    }

    /**
     * 设置产品生效时间
     *
     * @param effectiveDate 产品生效时间
     */
    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    /**
     * 获取产品失效时间
     *
     * @return expire_date - 产品失效时间
     */
    public Date getExpireDate() {
        return expireDate;
    }

    /**
     * 设置产品失效时间
     *
     * @param expireDate 产品失效时间
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
    public byte[] getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(byte[] remark) {
        this.remark = remark;
    }
}