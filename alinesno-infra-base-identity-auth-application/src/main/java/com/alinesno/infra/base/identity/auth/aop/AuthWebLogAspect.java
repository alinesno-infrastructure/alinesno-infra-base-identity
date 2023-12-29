package com.alinesno.infra.base.identity.auth.aop;

import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.URLUtil;
import com.alibaba.fastjson.JSONObject;
import com.alinesno.infra.base.identity.api.AuthWebLogDto;
import com.alinesno.infra.base.identity.auth.event.AuthWebLogEvent;
import com.alinesno.infra.base.identity.auth.event.PublishService;
import io.swagger.annotations.ApiOperation;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * 统一日志处理切面
 */
@Slf4j
@Aspect
@Component
@Order(1)
public class AuthWebLogAspect {

    @Autowired
    private PublishService publishService;

    @Pointcut("execution(public * com.alinesno.infra.base.identity.auth.controller.*.*(..))")
    public void webLog() {
    }

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
    }

    @AfterReturning(value = "webLog()", returning = "ret")
    public void doAfterReturning(Object ret) throws Throwable {
    }

    @Around("webLog()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {

        long startTime = System.currentTimeMillis();

        //获取当前请求对象
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert attributes != null;
        HttpServletRequest request = attributes.getRequest();

        //记录请求信息(通过Logstash传入Elasticsearch)
        AuthWebLogDto webLog = new AuthWebLogDto();

        Object result = joinPoint.proceed();
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();

        if (method.isAnnotationPresent(ApiOperation.class)) {
            ApiOperation log = method.getAnnotation(ApiOperation.class);
            webLog.setDescription(log.value());
        }
        long endTime = System.currentTimeMillis();

        String urlStr = request.getRequestURL().toString();

        webLog.setBasePath(StrUtil.removeSuffix(urlStr, URLUtil.url(urlStr).getPath()));
        webLog.setIp(request.getRemoteUser());
        webLog.setStartTime(startTime);
        webLog.setSpendTime((endTime - startTime)/1000);

        Map<String,Object> logMap = new HashMap<>();
        logMap.put("spendTime",webLog.getSpendTime());
        logMap.put("description",webLog.getDescription());

        webLog.setResult(result);

        log.info("weblog -->>> {}", JSONObject.toJSONString(webLog));

        CompletableFuture.runAsync(() -> {
            AuthWebLogEvent authWebLogEvent = new AuthWebLogEvent(webLog) ;
            publishService.publishEvent(authWebLogEvent);
        });

        return result;
    }
}
