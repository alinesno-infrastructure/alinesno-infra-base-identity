package com.alinesno.infra.base.identity.auth.config.strategy;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.util.PhoneUtil;
import com.alibaba.fastjson.JSONObject;
import com.alinesno.infra.base.authority.gateway.dto.ManagerAccountDto;
import com.alinesno.infra.base.identity.adapter.ManagerAccountConsumer;
import com.alinesno.infra.base.identity.adapter.dto.LoginParamDto;
import com.alinesno.infra.base.identity.auth.config.BaseLoginStrategy;
import com.alinesno.infra.base.identity.auth.dto.LoginUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * 账号登陆服务
 */
@Slf4j
@Service("accountLoginStrategy")
public class AccountLoginStrategy extends BaseLoginStrategy {

    @Autowired
    private ManagerAccountConsumer accountConsumer ;

    @Override
    public ManagerAccountDto strategyDoLogin(LoginUser loginUser) {

        log.debug("账号登陆.");

        // 判断用户是否已经存在，如果没有存在，则自动注册
        ManagerAccountDto accountDto = accountConsumer.findByLoginName(loginUser.getUsername()) ;
        if(accountDto == null){

            accountDto = new ManagerAccountDto() ;

            String loginName = loginUser.getUsername() ;  // 账号必须是手机号

            Assert.isTrue(PhoneUtil.isPhone(loginName) , "账号须为手机号，格式不正确");

            String password = loginUser.getPassword() ;
            String phone = loginUser.getUsername() ;

            accountDto.setLoginName(loginName);
            accountDto.setPassword(password);
            accountDto.setPhone(phone);

            accountConsumer.registerAccount (accountDto) ;
        }

        // 获取登陆用户
        LoginParamDto dto = new LoginParamDto() ;
        dto.setUsername(loginUser.getUsername());
        dto.setPassword(loginUser.getPassword());

        accountDto = accountConsumer.loginAccount(dto) ;
        log.debug("accountDto = {}" , JSONObject.toJSONString(accountDto));

        return accountDto;
    }

}
