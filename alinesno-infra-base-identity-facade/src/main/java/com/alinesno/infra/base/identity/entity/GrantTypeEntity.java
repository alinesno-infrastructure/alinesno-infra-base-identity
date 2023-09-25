package com.alinesno.infra.base.identity.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 功能名： 【请填写功能名称】
 * 数据表：  oauth_grant_type
 * 表备注：
 *
 * @author luoxiaondg
 * @version 1.0.0
 */
@TableName("grant_type")
public class GrantTypeEntity extends InfraBaseEntity {
    // fields
    /**
     * 授权类型名称
     */
    @Excel(name = "授权类型名称")
    @TableField("grant_type_name")
    private String grantTypeName;
    /**
     * 授权类型标识
     */
    @Excel(name = "授权类型标识")
    @TableField("grant_type_key")
    private String grantTypeKey;

    //getter and setter
    public String getGrantTypeName() {
        return this.grantTypeName;
    }

    public GrantTypeEntity setGrantTypeName(String arg) {
        this.grantTypeName = arg;
        return this;
    }

    public String getGrantTypeKey() {
        return this.grantTypeKey;
    }

    public GrantTypeEntity setGrantTypeKey(String arg) {
        this.grantTypeKey = arg;
        return this;
    }
}