package com.alinesno.infra.base.identity.adapter;

import com.alinesno.infra.base.authority.gateway.dto.ManagerAccountDto;
import com.alinesno.infra.base.identity.adapter.dto.LoginParamDto;
import com.dtflys.forest.annotation.BaseRequest;
import com.dtflys.forest.annotation.Body;
import com.dtflys.forest.annotation.Headers;
import com.dtflys.forest.annotation.Post;

/**
 * 账户接口
 */
@BaseRequest(baseURL = "#{alinesno.infra.gateway.host}/base-authority" , connectTimeout = 30*1000)
@Headers({
        "Content-Type: application/json",
        "Accept: */*",
        "Connection: keep-alive"
})
public interface ManagerAccountConsumer {

    /**
     * 账户注册
     * @param data
     * @return
     */
    @Post(url = "/v1/api/base/authority/account/registerAccount")
    ManagerAccountDto registerAccount(@Body ManagerAccountDto data);

    /**
     * 账户登陆
     * @param data
     * @return
     */
    @Post(url = "/v1/api/base/authority/account/login")
    ManagerAccountDto loginAccount(@Body LoginParamDto data);

}
