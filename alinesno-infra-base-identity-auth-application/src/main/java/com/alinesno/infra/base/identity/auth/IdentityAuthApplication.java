package com.alinesno.infra.base.identity.auth;

<<<<<<< HEAD
import com.dtflys.forest.springboot.annotation.ForestScan;
=======
>>>>>>> 43b05c79e94b3cd7c94301179a12fed265cba633
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 集成一个Java开发示例工具
 * @author LuoAnDong
 * @since 2023年8月3日 上午6:23:43
 */
<<<<<<< HEAD
@ForestScan(basePackages="com.alinesno.infra.base.identity.adapter")
=======
>>>>>>> 43b05c79e94b3cd7c94301179a12fed265cba633
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class IdentityAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(IdentityAuthApplication.class, args);
	}

}