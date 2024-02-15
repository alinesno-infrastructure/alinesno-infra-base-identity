package com.alinesno.infra.base.identity.auth;

import com.alibaba.fastjson.JSONObject;
import com.alinesno.infra.base.authority.gateway.dto.ManagerAccountDto;
import com.alinesno.infra.base.identity.adapter.ManagerAccountConsumer;
import com.alinesno.infra.base.identity.auth.config.IdentityAuthConfig;
import com.alinesno.infra.common.core.auto.EnableCore;
import com.alinesno.infra.common.web.adapter.utils.StringUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 集成一个Java开发示例工具
 * @author LuoAnDong
 * @since 2023年8月3日 上午6:23:43
 */
@EnableCore
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class IdentityAuthApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(IdentityAuthApplication.class, args);

		ManagerAccountConsumer managerAccountConsumer = context.getBean(ManagerAccountConsumer.class) ;
		ManagerAccountDto dto = managerAccountConsumer.findByLoginName("15578942577") ;

		System.out.println(dto.getLoginName());
		System.out.println(StringUtils.isNotBlank(dto.getLoginName()));

	}

}