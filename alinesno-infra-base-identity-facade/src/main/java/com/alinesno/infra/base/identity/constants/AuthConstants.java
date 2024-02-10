package com.alinesno.infra.base.identity.constants;

/**
 * 定义的变量信息
 */
public interface AuthConstants {

    String CURRENT_ACCOUNT_DTO = "currentAccountDto" ;

    int PHONE_CODE_EXPIRATION = 1 ; // 验证码1分钟过期
    String PHONE_CODE_KEY = "phone_code_codes:";

}
