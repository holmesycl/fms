package com.taohj.fms.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "user_login_info")
public class UserLoginInfo {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 电话号码
     */
    @Column(name = "phone_no")
    private String phoneNo;

    /**
     * 登录主机
     */
    private String host;

    /**
     * 登录时间
     */
    @Column(name = "login_date")
    private Date loginDate;

    /**
     * 登录结果
     */
    @Column(name = "login_state")
    private String loginState;

    /**
     * 创建时间
     */
    @Column(name = "create_date")
    private Date createDate;

    /**
     * 状态
     */
    private String state;

    /**
     * 备注信息
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
     * 获取电话号码
     *
     * @return phone_no - 电话号码
     */
    public String getPhoneNo() {
        return phoneNo;
    }

    /**
     * 设置电话号码
     *
     * @param phoneNo 电话号码
     */
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo == null ? null : phoneNo.trim();
    }

    /**
     * 获取登录主机
     *
     * @return host - 登录主机
     */
    public String getHost() {
        return host;
    }

    /**
     * 设置登录主机
     *
     * @param host 登录主机
     */
    public void setHost(String host) {
        this.host = host == null ? null : host.trim();
    }

    /**
     * 获取登录时间
     *
     * @return login_date - 登录时间
     */
    public Date getLoginDate() {
        return loginDate;
    }

    /**
     * 设置登录时间
     *
     * @param loginDate 登录时间
     */
    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    /**
     * 获取登录结果
     *
     * @return login_state - 登录结果
     */
    public String getLoginState() {
        return loginState;
    }

    /**
     * 设置登录结果
     *
     * @param loginState 登录结果
     */
    public void setLoginState(String loginState) {
        this.loginState = loginState == null ? null : loginState.trim();
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
     * 获取备注信息
     *
     * @return remark - 备注信息
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注信息
     *
     * @param remark 备注信息
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}