package com.alinesno.infra.base.identity.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import lombok.Data;
import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 存储应用实体类
 * </p>
 * <p>
 * 该类继承自InfraBaseEntity，表示存储应用的基本信息。
 * </p>
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@TableName("application")
@Data
public class ApplicationEntity extends InfraBaseEntity {

    /**
     * 应用名称
     */
    @TableField("application_name")
	@ColumnType(length=255)
	@ColumnComment("应用名称")
    private String applicationName;

    /**
     * 应用代码
     */
    @TableField("application_code")
	@ColumnType(length=50)
	@ColumnComment("应用代码")
    private String applicationCode;

    /**
     * 应用Logo
     */
    @TableField("logo")
    @ColumnType(length=255)
    @ColumnComment("应用Logo")
    private String logo;

    /**
     * 应用简介
     */
    @TableField("intro")
    @ColumnType(length=255)
    @ColumnComment("应用简介")
    private String intro;

    /**
     * 允许URL
     */
    @TableField("allow_url")
    @ColumnType(length=255)
    @ColumnComment("允许URL")
    private String allowUrl;

    /**
     * 是否公开
     */
    @TableField("is_public")
    @ColumnType(length=1)
    @ColumnComment("是否公开")
    private Integer isPublic;

}
