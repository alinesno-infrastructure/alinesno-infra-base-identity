package com.alinesno.infra.base.identity.entity;

import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 功能名： 【请填写功能名称】 数据表： cas_account 表备注：
 *
 * @author luoxiaondg
 * @version 1.0.0
 */
@TableName("white_account")
public class WhiteAccountEntity extends InfraBaseEntity {
	// fields
	/**
	 * 登陆账号
	 */
	@TableField("account")
	private String account;

	// getter and setter
	public String getAccount() {
		return this.account;
	}

	public WhiteAccountEntity setAccount(String arg) {
		this.account = arg;
		return this;
	}

}
