package com.alinesno.infra.base.identity.auth.config;

import cn.dev33.satoken.config.SaSsoConfig;
import cn.dev33.satoken.context.SaHolder;
import cn.dev33.satoken.session.SaSession;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import com.alibaba.fastjson.JSONObject;
import com.alinesno.infra.base.authority.gateway.dto.ManagerAccountDto;
import com.alinesno.infra.base.identity.adapter.ManagerAccountConsumer;
import com.alinesno.infra.base.identity.adapter.dto.LoginParamDto;
import com.alinesno.infra.base.identity.auth.dto.LoginUser;
import com.alinesno.infra.base.identity.auth.event.LoginRecordEvent;
import com.alinesno.infra.base.identity.auth.event.PublishService;
import com.alinesno.infra.base.identity.constants.AuthConstants;
import com.alinesno.infra.base.identity.entity.LoginRecordEntity;
import com.alinesno.infra.base.identity.enums.LoginTypeEnums;
import com.alinesno.infra.common.core.context.SpringContext;
import com.dtflys.forest.Forest;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import java.util.concurrent.CompletableFuture;

@Component
@Slf4j
public class SaTokenConfigure {

    @Autowired
    private PublishService publishService;

    // 配置SSO相关参数
    @Autowired
    private void configSso(SaSsoConfig sso) {

        // 配置：未登录时返回的View
        sso.setNotLoginView(() -> {
            return new ModelAndView("index.html");
        });

        // 配置：登录处理函数
        sso.setDoLoginHandle((name, pwd) -> {

            LoginUser loginUser = LoginUser.convertParamListToUser(SaHolder.getRequest()) ;
            log.debug("loginUser = {}" , loginUser) ;

            validateLoginKey(loginUser) ;  // 验证登陆信息是否正确

            BaseLoginStrategy loginStrategy = (BaseLoginStrategy) SpringContext.getBean(loginUser.getLoginType() + "LoginStrategy");
            ManagerAccountDto accountDto = loginStrategy.doLogin(loginUser) ;

            log.debug("accountDto = {}" , accountDto);

            StpUtil.login(accountDto.getId());

            // 设置会话信息
            SaSession session = StpUtil.getSession();
            session.set(AuthConstants.CURRENT_ACCOUNT_DTO , accountDto);

            // 登陆成功记录
            loginRecord() ;

            return SaResult.ok("登录成功！").setData(StpUtil.getTokenValue());
        });

        // 配置 Http 请求处理器 （在模式三的单点注销功能下用到，如不需要可以注释掉）
        sso.setSendHttp(url -> {
            try {
                // 发起 http 请求
                log.debug("------ 发起请求：" + url);
                return Forest.get(url).executeAsString();
            } catch (Exception e) {
                log.error("发起请求异常:{}" , e.getMessage());
                return null;
            }
        });
    }

    /**
     * 验证登陆是否正确，验证手机验证码和界面验证码
     * @param loginUser
     */
    private void validateLoginKey(LoginUser loginUser) {

    }

    /**
     * 用户登陆成功记录
     */
    private void loginRecord() {
        LoginRecordEntity dto = new LoginRecordEntity() ;

        final LoginRecordEvent userEvent = new LoginRecordEvent(dto);

        CompletableFuture.runAsync(() -> {
            publishService.publishEvent(userEvent);
        });

    }

}
