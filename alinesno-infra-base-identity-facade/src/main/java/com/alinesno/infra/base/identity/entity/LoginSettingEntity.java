package com.alinesno.infra.base.identity.entity;

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
@TableName("oauth_login_setting")
public class LoginSettingEntity extends InfraBaseEntity {

	private static final long serialVersionUID = 1L;

	private String themeCode ; // 品牌代码
	private int loginStyle; // :'0' , 登陆主题
	private int enableSociety; // : '1' 是否社会化登陆
	private int enableFindPwd; // : '1' , 是否允许找回密码
	private int lockTime; // : 250 , 锁定时长（按分钟）
	private int errorCount; // : 5, 错误次数
	private int enableValidate; // : '1', 是否显示二维码
	private String defaultIndex ; // 默认主页

	public String getThemeCode() {
		return themeCode;
	}

	public void setThemeCode(String themeCode) {
		this.themeCode = themeCode;
	}

	public String getDefaultIndex() {
		return defaultIndex;
	}

	public void setDefaultIndex(String defaultIndex) {
		this.defaultIndex = defaultIndex;
	}

	public int getLoginStyle() {
		return loginStyle;
	}

	public void setLoginStyle(int loginStyle) {
		this.loginStyle = loginStyle;
	}

	public int getEnableSociety() {
		return enableSociety;
	}

	public void setEnableSociety(int enableSociety) {
		this.enableSociety = enableSociety;
	}

	public int getEnableFindPwd() {
		return enableFindPwd;
	}

	public void setEnableFindPwd(int enableFindPwd) {
		this.enableFindPwd = enableFindPwd;
	}

	public int getLockTime() {
		return lockTime;
	}

	public void setLockTime(int lockTime) {
		this.lockTime = lockTime;
	}

	public int getErrorCount() {
		return errorCount;
	}

	public void setErrorCount(int errorCount) {
		this.errorCount = errorCount;
	}

	public int getEnableValidate() {
		return enableValidate;
	}

	public void setEnableValidate(int enableValidate) {
		this.enableValidate = enableValidate;
	}

	@Override
	public String toString() {
		return "OauthLoginSettingEntity [loginStyle=" + loginStyle + ", enableSociety=" + enableSociety
				+ ", enableFindPwd=" + enableFindPwd + ", lockTime=" + lockTime + ", errorCount=" + errorCount
				+ ", enableValidate=" + enableValidate + "]";
	}

}
