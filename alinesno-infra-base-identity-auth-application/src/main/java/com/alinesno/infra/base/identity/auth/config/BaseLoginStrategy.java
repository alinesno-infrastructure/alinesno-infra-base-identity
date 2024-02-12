package com.alinesno.infra.base.identity.auth.config;

import com.alinesno.infra.base.authority.gateway.dto.ManagerAccountDto;
import com.alinesno.infra.base.identity.auth.dto.LoginUser;

/**
 * 用户登陆基础类，实现多种登陆策略父类
 */
public abstract class BaseLoginStrategy {

    /**
     * 用户登陆
     * @return
     */
    public ManagerAccountDto doLogin(LoginUser loginUser){
        // TODO 登陆前逻辑处理
        return strategyDoLogin(loginUser) ;
    }

    /**
     * 自定义登陆
     * @param loginUser
     * @return
     */
    public abstract ManagerAccountDto strategyDoLogin(LoginUser loginUser) ;

}
