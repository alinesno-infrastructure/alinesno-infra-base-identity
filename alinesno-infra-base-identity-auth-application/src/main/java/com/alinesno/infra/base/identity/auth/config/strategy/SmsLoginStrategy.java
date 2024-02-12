package com.alinesno.infra.base.identity.auth.config.strategy;

import com.alinesno.infra.base.authority.gateway.dto.ManagerAccountDto;
import com.alinesno.infra.base.identity.adapter.ManagerAccountConsumer;
import com.alinesno.infra.base.identity.auth.config.BaseLoginStrategy;
import com.alinesno.infra.base.identity.auth.dto.LoginUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 短信登陆服务
 */
@Slf4j
@Service("smsLoginStrategy")
public class SmsLoginStrategy extends BaseLoginStrategy {

    @Autowired
    private ManagerAccountConsumer accountConsumer ;

    @Override
    public ManagerAccountDto strategyDoLogin(LoginUser loginUser) {

        log.debug("手机验证码登陆.");

        // 判断用户是否已经存在，如果没有存在，则自动注册
        ManagerAccountDto accountDto = accountConsumer.findByLoginName(loginUser.getUsername()) ;
        if(accountDto == null){

            accountDto = new ManagerAccountDto() ;

            String loginName = loginUser.getPhoneNumber() ;
            String password = loginUser.getPhoneCode() ;
            String phone = loginUser.getPhoneNumber() ;

            accountDto.setLoginName(loginName);
            accountDto.setPassword(password);
            accountDto.setPhone(phone);

            accountConsumer.registerAccount (accountDto) ;
        }

        return null;
    }
}
