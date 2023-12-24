package com.alinesno.infra.base.identity.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import lombok.Data;
import cn.afterturn.easypoi.excel.annotation.Excel;
import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.EqualsAndHashCode;

/**
 * 功能名： 【请填写功能名称】
 * 数据表：  oauth_authority_scope
 * 表备注：
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@TableName("authority_scope")
@Data
public class AuthorityScopeEntity extends InfraBaseEntity {
    // fields
    /**
     * 授权范围名称
     */
    @Excel(name = "授权范围名称")
    @TableField("scope_name")
    @ColumnType(length=50)
    @ColumnComment("授权范围名称")
    private String scopeName;
    /**
     * 授权范围标识
     */
    @Excel(name = "授权范围标识")
    @TableField("scope_key")
    @ColumnType(length=255)
    @ColumnComment("授权范围标识")
    private String scopeKey;
}