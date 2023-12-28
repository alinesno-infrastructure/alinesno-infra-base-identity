package com.alinesno.infra.base.identity.adapter;

import com.alinesno.infra.common.facade.response.AjaxResult;
import com.dtflys.forest.annotation.BaseRequest;
import com.dtflys.forest.annotation.Get;
import com.dtflys.forest.annotation.Query;

/**
 * 单点登陆账户操作接口
 */
@BaseRequest(baseURL = "#{alinesno.infra.gateway.host}/base-identity-auth" , connectTimeout = 30*1000)
public interface IdentityAccountConsumer {

    // 将指定账号强制注销
    @Get(url="/kickout/logout")
    AjaxResult logout(@Query String userId) ;

    // 将指定账号踢下线
    @Get(url="/kickout")
    AjaxResult kickout(@Query String userId) ;

    // 根据 Token 值踢人
    @Get(url="/kickout/kickoutByTokenValue")
    AjaxResult kickoutByTokenValue(@Query String tokenValue) ;

    // 封禁指定账号
    @Get(url = "/disable")
    AjaxResult disable(@Query String userId);

    // 解封指定账号
    @Get(url = "/disable/untieDisable")
    AjaxResult untieDisable(@Query String userId);

    // 身份切换
    @Get(url = "/switchTo")
    AjaxResult switchTo(@Query String userId);

    // 以 lambda 表达式的方式身份切换
    @Get(url = "/switchToUser")
    AjaxResult switchToUser(@Query String userId);

    // 会话查询接口 ---- http://localhost:8081/search/getList?start=0&size=10
    @Get(url="/search/getList")
    AjaxResult getList(int start, int size) ;
}
