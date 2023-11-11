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
 * <p>
 * 企业主题配置
 * </p>
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@TableName("enterprise_theme")
@Data
public class EnterpriseThemeEntity extends InfraBaseEntity {

	/**
	 * 登录SEO标题
	 */
	@Excel(name = "登录SEO标题")
	@TableField("login_seo_title")
	@ColumnType(length=50)
	@ColumnComment("登录SEO标题")
	private String loginSeoTitle;
	/**
	 * 登录SEO描述
	 */
	@Excel(name = "登录SEO描述")
	@TableField("login_seo_description")
	@ColumnType(length=255)
	@ColumnComment("登录SEO描述")
	private String loginSeoDescription;
	/**
	 * 登录SEO关键字
	 */
	@Excel(name = "登录SEO关键字")
	@TableField("login_seo_keyword")
	@ColumnType(length=255)
	@ColumnComment("登录SEO关键字")
	private String loginSeoKeyword;
	/**
	 * 登录LOGO
	 */
	@Excel(name = "登录LOGO")
	@TableField("login_logo")
	@ColumnType(length=255)
	@ColumnComment("登录LOGO")
	private String loginLogo;
	@TableField(exist = false)
	@ColumnType(length=255)
	@ColumnComment("loginLogoPath")
	private String loginLogoPath;
	/**
	 * 登录背景图
	 */
	@Excel(name = "登录背景图")
	@TableField("logo_background")
	@ColumnType(length=50)
	@ColumnComment("登录背景图")
	private String logoBackground;

	@TableField(exist = false)
	@ColumnType(length=255)
	@ColumnComment("logo背景路径")
	private String logoBackgroundPath;
	/**
	 * 登录标题
	 */
	@Excel(name = "登录标题")
	@TableField("logo_title")
	@ColumnType(length=50)
	@ColumnComment("登录标题")
	private String logoTitle;
	/**
	 * 配置名称
	 */
	@Excel(name = "配置名称")
	@TableField("config_name")
	@ColumnType(length=255)
	@ColumnComment("配置名称")
	private String configName;

	@Excel(name = "主题颜色")
	@TableField("login_color")
	@ColumnType(length=20)
	@ColumnComment("登录颜色")
	private String loginColor;

	@TableField("login_description")
	@ColumnType(length=255)
	@ColumnComment("登录描述")
	private String loginDescription;

	// 权限声明
	@TableField("power_desc")
	@ColumnType(length=255)
	@ColumnComment("权限声明")
	private String powerDesc ;

	// 是否存在验证码登陆
	@TableField("has_qr_login")
	@ColumnType(length=1)
	@ColumnComment("是否存在验证码登陆")
	private int hasQrLogin ;

	@TableField("theme_code")
	@ColumnType(length=10)
	@ColumnComment("主题代码")
	private String themeCode ; // 主题代码
}
