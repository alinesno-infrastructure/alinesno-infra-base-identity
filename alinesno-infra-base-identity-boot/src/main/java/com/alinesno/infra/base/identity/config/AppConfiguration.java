package com.alinesno.infra.base.identity.config;

import com.alinesno.infra.common.facade.enable.EnableActable;
import com.alinesno.infra.common.web.adapter.sso.enable.EnableInfraSsoApi;
import com.dtflys.forest.springboot.annotation.ForestScan;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@ForestScan(basePackages="com.alinesno.infra.base.identity.adapter")
@EnableActable
@MapperScan("com.alinesno.infra.base.identity.mapper")
@Configuration
@EnableInfraSsoApi
public class AppConfiguration {
}
