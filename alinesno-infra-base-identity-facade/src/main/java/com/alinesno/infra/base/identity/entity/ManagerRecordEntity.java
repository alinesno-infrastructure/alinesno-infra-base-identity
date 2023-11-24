package com.alinesno.infra.base.identity.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import lombok.Data;
import cn.afterturn.easypoi.excel.annotation.Excel;
import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.EqualsAndHashCode;

import javax.persistence.Basic;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import java.util.Date;

/**
 * 用户操作记录
 *
 * @author luoxiaondg
 * @version 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@TableName("manager_record")
@Data
public class ManagerRecordEntity extends InfraBaseEntity {

    /* @Excel(name = "操作说明") */
    @TableField
    @ColumnType(length=50)
    @ColumnComment("用户操作记录")
    private String operation;

    @Excel(name = "执行时间")
    @TableField("method_time")
    @ColumnType(length=8)
    @ColumnComment("执行时间")
    private long methodTime;

    @Excel(name = "类方法")
    @TableField("method")
    @ColumnType(length=50)
    @ColumnComment("类方法")
    private String method;

    @Excel(name = "请求参数")
    @Lob
    @TableField("params")
    @Basic(fetch = FetchType.LAZY)
    @ColumnType(length=255)
    @ColumnComment("请求参数")
    private String params;

    @Excel(name = "方法描述")
    @TableField("method_desc")
    @ColumnType(length=255)
    @ColumnComment("方法描述")
    private String methodDesc;

    @Excel(name = "请求记录")
    @TableField("record_type")
    @ColumnType(length=20)
    @ColumnComment("请求记录")
    private String recordType; // 记录类型

    @Excel(name = "服务器IP")
    @TableField("ip")
    @ColumnType(length=15)
    @ColumnComment("IP地址")
    private String ip; // 服务器ip

    @Excel(name = "请求链接")
    @TableField("url")
    @ColumnType(length=255)
    @ColumnComment("请求链接")
    private String url; // 请求链接

    @Excel(name = "浏览器信息")
    @TableField("agent")
    @ColumnType(length=255)
    @ColumnComment("浏览器信息")
    private String agent; // 浏览器信息

    @TableField("create_time")
    @ColumnType(length=255)
    @ColumnComment("创建时间")
    private Date createTime;

    @TableField("account_id")
    @ColumnType(length=255)
    @ColumnComment("账户ID")
    private String accountId;

    @Excel(name = "登陆名")
    @TableField("login_name")
    @ColumnType(length=255)
    @ColumnComment("登录名")
    private String loginName;

    @Excel(name = "用户名")
    @TableField("account_name")
    @ColumnType(length=255)
    @ColumnComment("用户名")
    private String accountName;

    @TableField("role_power")
    @ColumnType(length=255)
    @ColumnComment("角色权限")
    private String rolePower;
}
