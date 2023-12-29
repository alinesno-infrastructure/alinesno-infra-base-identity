package com.alinesno.infra.base.identity.api;

import lombok.Data;

/**
 * Controller层的日志封装类
 */
@Data
public class AuthWebLogDto {

    private String description;
    private String username;
    private Long startTime;
    private Long spendTime;
    private String basePath;
    private String uri;
    private String url;
    private String method;
    private String ip;
    private Object parameter;
    private Object result;

}
