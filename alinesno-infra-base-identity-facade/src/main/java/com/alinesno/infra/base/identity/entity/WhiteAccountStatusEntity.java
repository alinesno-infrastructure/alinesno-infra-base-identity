package com.alinesno.infra.base.identity.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import lombok.Data;
import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 功能名： 【请填写功能名称】 数据表： cas_account 表备注：
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@TableName("white_account_status")
@Data
public class WhiteAccountStatusEntity extends InfraBaseEntity {
	/**
	 * 登陆账号
	 */
	@TableField("has_open")
	@ColumnType(length=255)
	@ColumnComment("登陆账号")
	private int hasOpen;
}
