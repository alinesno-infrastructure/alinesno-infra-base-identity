package com.alinesno.infra.base.identity.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import lombok.Data;
import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.EqualsAndHashCode;

/**
 * 功能名： 【请填写功能名称】 数据表： cas_account 表备注：
 *
 * @author luoxiaondg
 * @version 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@TableName("white_account")
@Data
public class WhiteAccountEntity extends InfraBaseEntity {
	// fields
	/**
	 * 登陆账号
	 */
	@TableField("account")
	@ColumnType(length=255)
	@ColumnComment("登陆账号")
	private String account;
}
