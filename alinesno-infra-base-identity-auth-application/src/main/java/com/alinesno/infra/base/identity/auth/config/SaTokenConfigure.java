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
    private ManagerAccountConsumer accountConsumer ;

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

            LoginParamDto dto = new LoginParamDto() ;

            dto.setUsername(loginUser.getUsername());
            dto.setPassword(loginUser.getPassword());

            ManagerAccountDto accountDto = getManagerAccountDto(loginUser, dto);

            log.debug("isLogin = {}" , StpUtil.isLogin());

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
     * 判断用户是否注册，如果没有则注册则自动注册
     * @param loginUser
     * @param dto
     * @return
     */
    @NotNull
    private ManagerAccountDto getManagerAccountDto(LoginUser loginUser, LoginParamDto dto) {
        // 判断用户是否已经存在，如果没有存在，则自动注册
        ManagerAccountDto accountDto = accountConsumer.findByLoginName(loginUser.getUsername()) ;
        if(accountDto == null){

            accountDto = new ManagerAccountDto() ;

            String loginName = dto.getUsername() ;
            String password = dto.getPassword() ;
            String phone = dto.getUsername() ;

            accountDto.setLoginName(loginName);
            accountDto.setPassword(password);
            accountDto.setPhone(phone);

            accountConsumer.registerAccount (accountDto) ;
        }

        // 获取登陆用户
        accountDto = accountConsumer.loginAccount(dto) ;
        log.debug("accountDto = {}" , JSONObject.toJSONString(accountDto));

        // 此处仅做模拟登录，真实环境应该查询数据进行登录
        StpUtil.login(accountDto.getId());
        return accountDto;
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
