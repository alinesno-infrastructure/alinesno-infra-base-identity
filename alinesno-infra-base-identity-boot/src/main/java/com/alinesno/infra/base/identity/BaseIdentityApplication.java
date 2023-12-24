package com.alinesno.infra.base.identity;

<<<<<<< HEAD
=======
import com.alinesno.infra.common.facade.enable.EnableActable;
>>>>>>> 43b05c79e94b3cd7c94301179a12fed265cba633
import com.alinesno.infra.common.web.adapter.sso.enable.EnableInfraSsoApi;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 集成一个Java开发示例工具
 * @author LuoAnDong
 * @since 2023年8月3日 上午6:23:43
 */
@EnableInfraSsoApi
<<<<<<< HEAD
=======
@EnableActable
>>>>>>> 43b05c79e94b3cd7c94301179a12fed265cba633
@MapperScan("com.alinesno.infra.base.identity.mapper")
@SpringBootApplication
public class BaseIdentityApplication {

	public static void main(String[] args) {
		SpringApplication.run(BaseIdentityApplication.class, args);
	}

}