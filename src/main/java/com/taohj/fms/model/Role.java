package com.taohj.fms.model;

import java.util.Date;
import javax.persistence.*;

public class Role {
    /**
     * 角色ID
     */
    @Id
    @Column(name = "role_id")
    private Integer roleId;

    /**
     * 角色编码
     */
    @Column(name = "role_code")
    private String roleCode;

    /**
     * 角色名称
     */
    @Column(name = "role_name")
    private String roleName;

    /**
     * 角色描述
     */
    @Column(name = "role_desc")
    private String roleDesc;

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
     * 备注信息
     */
    private String remark;

    /**
     * 获取角色ID
     *
     * @return role_id - 角色ID
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * 设置角色ID
     *
     * @param roleId 角色ID
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * 获取角色编码
     *
     * @return role_code - 角色编码
     */
    public String getRoleCode() {
        return roleCode;
    }

    /**
     * 设置角色编码
     *
     * @param roleCode 角色编码
     */
    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode == null ? null : roleCode.trim();
    }

    /**
     * 获取角色名称
     *
     * @return role_name - 角色名称
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * 设置角色名称
     *
     * @param roleName 角色名称
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    /**
     * 获取角色描述
     *
     * @return role_desc - 角色描述
     */
    public String getRoleDesc() {
        return roleDesc;
    }

    /**
     * 设置角色描述
     *
     * @param roleDesc 角色描述
     */
    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc == null ? null : roleDesc.trim();
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
     * @param lastModifyDate 最后一次修改时间
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