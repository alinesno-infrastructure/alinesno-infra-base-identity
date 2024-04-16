package com.alinesno.infra.base.identity.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import lombok.Data;
import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 企业主题配置
 * </p>
 *
 * @author luoxiaondg
 * @version 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@TableName("login_setting")
@Data
public class LoginSettingEntity extends InfraBaseEntity {

	@ColumnType(length=10)
	@ColumnComment("登陆主题")
	@TableField("login_style")
	private int loginStyle;

	@ColumnType(length=1)
	@ColumnComment("是否社会化登陆")
	@TableField("enable_society")
	private int enableSociety;

	@ColumnType(length=1)
	@ColumnComment("是否允许找回密码")
	@TableField("enable_find_pwd")
	private int enableFindPwd;

	@ColumnType(length=8)
	@ColumnComment("锁定时间")
	@TableField("lock_time")
	private int lockTime;

	@ColumnType(length=255)
	@ColumnComment("错误计数")
	@TableField("error_count")
	private int errorCount;

	@ColumnType(length=1)
	@ColumnComment("是否显示二维码")
	@TableField("enable_validate")
	private int enableValidate;

}