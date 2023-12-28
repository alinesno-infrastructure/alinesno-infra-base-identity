package com.alinesno.infra.base.identity.adapter;

import com.alinesno.infra.base.identity.entity.LoginEventEntity;
import com.alinesno.infra.base.identity.entity.LoginRecordEntity;
import com.dtflys.forest.annotation.BaseRequest;
import com.dtflys.forest.annotation.Body;
import com.dtflys.forest.annotation.Headers;
import com.dtflys.forest.annotation.Post;

/**
 * 记录登陆事件信息
 */
@BaseRequest(baseURL = "#{alinesno.infra.gateway.host}/base-identity" , connectTimeout = 30*1000)
@Headers({
        "Content-Type: application/json",
        "Accept: */*",
        "Connection: keep-alive"
})
public interface LoginEventConsumer {

    /**
     * 记录登陆事件日志信息
     */
    @Post(url = "/v1/api/base/identity/event/record")
    void eventRecord(@Body LoginEventEntity dto);

    /**
     * 登陆日志信息
     * @param dto
     */
    @Post(url = "/v1/api/base/identity/login/record")
    void loginRecord(@Body LoginRecordEntity dto);

}
