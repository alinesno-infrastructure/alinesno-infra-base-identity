package com.alinesno.infra.base.identity.auth;

import com.alinesno.infra.common.core.auto.EnableCore;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 集成一个Java开发示例工具
 * @author LuoAnDong
 * @since 2023年8月3日 上午6:23:43
 */
@EnableCore
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class IdentityAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(IdentityAuthApplication.class, args);
	}

}