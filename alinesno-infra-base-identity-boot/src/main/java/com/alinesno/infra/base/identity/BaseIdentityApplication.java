package com.alinesno.infra.base.identity;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 集成一个Java开发示例工具
 * @author LuoAnDong
 * @since 2023年8月3日 上午6:23:43
 */
@MapperScan("com.alinesno.infra.base.identity.mapper")
@SpringBootApplication
public class BaseIdentityApplication {

	public static void main(String[] args) {
		SpringApplication.run(BaseIdentityApplication.class, args);
	}

}