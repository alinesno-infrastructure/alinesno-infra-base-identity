package com.alinesno.infra.base.identity.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * <p>
 * 用户登陆记录表
 * </p>
 *
 * @author luoxiaondg
 * @version 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("login_record")
public class LoginRecordEntity extends InfraBaseEntity {

	/**
	 * 登陆名
	 */
	@Excel(name = "登陆名")
	@TableField("login_name")
	private String loginName;

	/**
	 * 登陆时间
	 */
	@Excel(name = "登陆时间", format = "yyyy-MM-dd HH:mm:ss")
	@TableField("login_time")
	private Date loginTime;
	/**
	 * 登陆IP
	 */
	@Excel(name = "登陆IP")
	@TableField("login_ip")
	private String loginIp;
	/**
	 * 登陆状态(1成功|0失败)
	 */
	@Excel(name = "登陆状态", replace = { "成功_1", "失败_0", "_null" })
	@TableField("login_status")
	private String loginStatus;
	/**
	 * 错误密码
	 */
	@Excel(name = "错误密码")
	@TableField("error_password")
	private String errorPassword;
	/**
	 * 手机验证码
	 */
	@Excel(name = "手机验证码")
	@TableField("phone_code")
	private String phoneCode;
	/**
	 * 邮箱验证码
	 */
	@Excel(name = "邮箱验证码")
	@TableField("email_code")
	private String emailCode;
	/**
	 * 登陆来源
	 */
	@Excel(name = "登陆来源")
	@TableField("login_src")
	private String loginSrc;
	/**
	 * 退出时间
	 */
	@Excel(name = "退出时间", format = "yyyy-MM-dd HH:mm:ss")
	@TableField("sign_out_time")
	private Date signOutTime;
	/**
	 * 浏览器信息
	 */
	@Excel(name = "浏览器信息")
	@TableField("login_browser")
	private String loginBrowser;
	/**
	 * 登陆备注
	 */
	@Excel(name = "登陆备注")
	@TableField("login_remark")
	private String loginRemark;
	
	// 区域和城市信息

	@TableField("ip_info")
	private String ipInfo; // 区域信息 

	@TableField("log_type")
	private String logType; // 操作类型

	@TableField("client_type")
	private String clientType; // 判断是PC/Desktop

	@TableField("brower_type")
	private String browerType; // 浏览器类型
	
	@TableField("tentant_domain")
	private String tentantDomain ; // 租户域名
}
