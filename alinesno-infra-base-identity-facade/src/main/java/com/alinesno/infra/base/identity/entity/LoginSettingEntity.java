package com.alinesno.infra.base.identity.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import lombok.Data;
import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * <p>
 * 企业主题配置
 * </p>
 *
 * @author luoxiaondg
 * @version 1.0.0
 */
@TableName("login_setting")
@Data
public class LoginSettingEntity extends InfraBaseEntity {

	@ColumnType(length=10)
	@ColumnComment("品牌代码")
	@TableField("theme_cod")
	private String themeCode ; // 品牌代码

	@ColumnType(length=10)
	@ColumnComment("登陆主题")
	@TableField("login_style")
	private int loginStyle; // :'0' , 登陆主题

	@ColumnType(length=1)
	@ColumnComment("是否社会化登陆")
	@TableField("enable_society")
	private int enableSociety; // : '1' 是否社会化登陆

	@ColumnType(length=1)
	@ColumnComment("是否允许找回密码")
	@TableField("enable_find_pwd")
	private int enableFindPwd; // : '1' , 是否允许找回密码

	@ColumnType(length=8)
	@ColumnComment("锁定时间")
	@TableField("lock_time")
	private int lockTime; // : 250 , 锁定时长（按分钟）

	@ColumnType(length=255)
	@ColumnComment("错误计数")
	@TableField("error_count")
	private int errorCount; // : 5, 错误次数

	@ColumnType(length=1)
	@ColumnComment("是否显示二维码")
	@TableField("enable_validate")
	private int enableValidate; // : '1', 是否显示二维码

	@ColumnType(length=1)
	@ColumnComment("默认主页")
	@TableField("default_inde")
	private String defaultIndex ; // 默认主页
}
