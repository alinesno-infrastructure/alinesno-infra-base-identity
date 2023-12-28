package com.alinesno.infra.base.identity.auth.config;

import com.dtflys.forest.springboot.annotation.ForestScan;
import org.springframework.context.annotation.Configuration;

@ForestScan(basePackages="com.alinesno.infra.base.identity.adapter")
@Configuration
public class AppConfiguration {
}
