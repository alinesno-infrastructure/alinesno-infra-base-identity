package com.alinesno.infra.base.identity.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 功能名： 【请填写功能名称】
 * 数据表：  oauth_authority_scope
 * 表备注：
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@TableName("oauth_authority_scope")
public class AuthorityScopeEntity extends InfraBaseEntity {
    // fields
    /**
     * 授权范围名称
     */
    @Excel(name = "授权范围名称")
    @TableField("scope_name")
    private String scopeName;
    /**
     * 授权范围标识
     */
    @Excel(name = "授权范围标识")
    @TableField("scope_key")
    private String scopeKey;

    //getter and setter
    public String getScopeName() {
        return this.scopeName;
    }

    public AuthorityScopeEntity setScopeName(String arg) {
        this.scopeName = arg;
        return this;
    }

    public String getScopeKey() {
        return this.scopeKey;
    }

    public AuthorityScopeEntity setScopeKey(String arg) {
        this.scopeKey = arg;
        return this;
    }
}
