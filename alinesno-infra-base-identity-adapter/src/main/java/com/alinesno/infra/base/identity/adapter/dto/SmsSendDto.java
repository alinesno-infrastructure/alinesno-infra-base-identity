package com.alinesno.infra.base.identity.adapter.dto;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * 消息通知服务
 */
@Data
public class SmsSendDto {

    private String phone ;
    private String configId = "alibaba" ;
    private String phoneCode ;

    private Map<String , String> messageMap ;

    public static SmsSendDto getSmsDto(String phone , String phoneCode){
        return new SmsSendDto(phone , "alibaba" , phoneCode) ;
    }

    public SmsSendDto(String phone, String configId, String phoneCode) {
        this.phone = phone;
        this.configId = configId;
        this.phoneCode = phoneCode;

        messageMap = new HashMap<>() ;
        messageMap.put("code" , phoneCode) ;
    }

}