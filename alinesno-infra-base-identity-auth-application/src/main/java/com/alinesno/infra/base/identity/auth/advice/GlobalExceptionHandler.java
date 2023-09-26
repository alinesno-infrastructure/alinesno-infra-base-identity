package com.alinesno.infra.base.identity.auth.advice;

import cn.dev33.satoken.util.SaResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    // 全局异常拦截 
    @ExceptionHandler
    public SaResult handlerException(Exception e) {

        log.error("前端异常:{}" , e.getMessage());

        return SaResult.error(e.getMessage());
    }
}
