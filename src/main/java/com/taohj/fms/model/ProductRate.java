package com.taohj.fms.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "product_rate")
public class ProductRate {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 产品
     */
    @Column(name = "product_id")
    private Integer productId;

    /**
     * 收益率
     */
    private Float rate;

    /**
     * 创建时间
     */
    @Column(name = "cteate_date")
    private Date cteateDate;

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
     * @param productId 产品
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /**
     * 获取收益率
     *
     * @return rate - 收益率
     */
    public Float getRate() {
        return rate;
    }

    /**
     * 设置收益率
     *
     * @param rate 收益率
     */
    public void setRate(Float rate) {
        this.rate = rate;
    }

    /**
     * 获取创建时间
     *
     * @return cteate_date - 创建时间
     */
    public Date getCteateDate() {
        return cteateDate;
    }

    /**
     * 设置创建时间
     *
     * @param cteateDate 创建时间
     */
    public void setCteateDate(Date cteateDate) {
        this.cteateDate = cteateDate;
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