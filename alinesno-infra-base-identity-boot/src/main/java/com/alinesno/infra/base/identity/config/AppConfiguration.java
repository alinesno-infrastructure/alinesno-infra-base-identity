package com.alinesno.infra.base.identity.config;

import com.alinesno.infra.common.facade.enable.EnableActable;
import com.alinesno.infra.common.web.adapter.sso.enable.EnableInfraSsoApi;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@EnableInfraSsoApi
@EnableActable
@MapperScan("com.alinesno.infra.base.identity.mapper")
@Configuration
public class AppConfiguration {
}
