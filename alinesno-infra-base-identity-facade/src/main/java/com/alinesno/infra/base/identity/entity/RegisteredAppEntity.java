package com.alinesno.infra.base.identity.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import org.apache.commons.lang.StringUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 功能名： 【请填写功能名称】
 * 数据表：  oauth_registered_app
 * 表备注：
 *
 * @author luoxiaondg
 * @version 1.0.0
 */
@TableName("registered_app")
public class RegisteredAppEntity extends InfraBaseEntity {
    // fields
    /**
     * 应用名称
     */
    @Excel(name = "应用名称")
    @TableField("app_name")
    private String appName;
    /**
     * 应用秘钥
     */
    @Excel(name = "应用秘钥")
    @TableField("app_secret")
    private String appSecret;
    /**
     * 应用简要描述
     */
    @Excel(name = "应用简要描述")
    @TableField("app_desc")
    private String appDesc;
    /**
     * 授权码回调地址
     */
    @Excel(name = "授权码回调地址")
    @TableField("redirec_uri")
    private String redirecUri;
    /**
     * 是否自动授权
     */
    @Excel(name = "是否自动授权")
    @TableField("auto_approve")
    private Long autoApprove;
    /**
     * 支持的授权模式
     */
    @Excel(name = "支持的授权模式")
    @TableField("authority_grant_type")
    private String authorityGrantType;

    @TableField(exist = false)
    private List<String> authorityGrantTypes;


    /**
     * 应用授权环境标识
     */
    @Excel(name = "应用授权环境标识")
    @TableField("app_env")
    private String appEnv;
    /**
     * 应用类型
     */
    @Excel(name = "应用类型")
    @TableField("app_type")
    private String appType;
    /**
     * 应用类型
     */
    @Excel(name = "应用服务地址")
    @TableField("server_url")
    private String serverUrl;

    /**
     * 应用授权范围
     */
    @Excel(name = "应用授权范围")
    @TableField("authority_scope")
    private String authorityScope;

    @TableField(exist = false)
    private List<String> authorityScopes;


    //getter and setter


    public List<String> getAuthorityGrantTypes() {
        return authorityGrantTypes;
    }

    public RegisteredAppEntity setAuthorityGrantTypes(List<String> authorityGrantTypes) {
        this.authorityGrantTypes = authorityGrantTypes;
        return this;
    }

    public String getServerUrl() {
        return serverUrl;
    }

    public RegisteredAppEntity setServerUrl(String serverUrl) {
        this.serverUrl = serverUrl;
        return this;
    }

    public List<String> getAuthorityScopes() {
        return authorityScopes;
    }

    public RegisteredAppEntity setAuthorityScopes(List<String> authorityScopes) {
        this.authorityScopes = authorityScopes;
        return this;
    }

    public String getAppName() {
        return this.appName;
    }

    public RegisteredAppEntity setAppName(String arg) {
        this.appName = arg;
        return this;
    }

    public String getAuthorityScope() {
        return authorityScope;
    }

    public RegisteredAppEntity setAuthorityScope(String authorityScope) {
        this.authorityScope = authorityScope;
        return this;
    }

    public String getAppSecret() {
        return this.appSecret;
    }

    public RegisteredAppEntity setAppSecret(String arg) {
        this.appSecret = arg;
        return this;
    }

    public String getAppDesc() {
        return this.appDesc;
    }

    public RegisteredAppEntity setAppDesc(String arg) {
        this.appDesc = arg;
        return this;
    }

    public String getRedirecUri() {
        return this.redirecUri;
    }

    public RegisteredAppEntity setRedirecUri(String arg) {
        this.redirecUri = arg;
        return this;
    }

    public Long getAutoApprove() {
        return this.autoApprove;
    }

    public RegisteredAppEntity setAutoApprove(Long arg) {
        this.autoApprove = arg;
        return this;
    }

    public String getAuthorityGrantType() {
        return this.authorityGrantType;
    }

    public RegisteredAppEntity setAuthorityGrantType(String arg) {
        this.authorityGrantType = arg;
        return this;
    }

    public String getAppEnv() {
        return this.appEnv;
    }

    public RegisteredAppEntity setAppEnv(String arg) {
        this.appEnv = arg;
        return this;
    }

    public String getAppType() {
        return this.appType;
    }

    public RegisteredAppEntity setAppType(String arg) {
        this.appType = arg;
        return this;
    }

    public List<String> authorityGrantTypes() {
        if (StringUtils.isNotBlank(authorityGrantType)) {
            return Arrays.asList(authorityGrantType.split(","));
        }
        return Collections.emptyList();
    }

    public List<String> authorityScopes() {
        if (StringUtils.isNotBlank(authorityScope)) {
            return Arrays.asList(authorityScope.split(","));
        }
        return Collections.emptyList();

    }
}
