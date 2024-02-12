package com.alinesno.infra.base.identity.adapter;

import com.alinesno.infra.base.identity.adapter.dto.SmsSendDto;
import com.alinesno.infra.common.facade.response.AjaxResult;
import com.dtflys.forest.annotation.BaseRequest;
import com.dtflys.forest.annotation.Body;
import com.dtflys.forest.annotation.Headers;
import com.dtflys.forest.annotation.Post;

/**
 * 消息服务
 */
@BaseRequest(baseURL = "#{alinesno.infra.gateway.host}/base-notice" , connectTimeout = 30*1000)
@Headers({
        "Content-Type: application/json",
        "Accept: */*",
        "Connection: keep-alive"
})
public interface BaseNoticeConsumer {

    /**
     * 获取手机验证码
     * @param smsSendDto
     * @return
     */
    @Post(url = "/v1/base/notice/sms/sendMessageMap")
    AjaxResult smsSendMessageMap(@Body SmsSendDto smsSendDto);

}
