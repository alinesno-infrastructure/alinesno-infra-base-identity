package com.alinesno.infra.base.identity.auth.config;

import cn.dev33.satoken.config.SaSsoConfig;
import cn.dev33.satoken.context.SaHolder;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import com.alinesno.infra.base.authority.gateway.dto.ManagerAccountDto;
import com.alinesno.infra.base.identity.adapter.LoginEventConsumer;
import com.alinesno.infra.base.identity.adapter.ManagerAccountConsumer;
import com.alinesno.infra.base.identity.adapter.dto.LoginParamDto;
import com.alinesno.infra.base.identity.auth.dto.LoginUser;
import com.alinesno.infra.base.identity.auth.event.LoginRecordEvent;
import com.alinesno.infra.base.identity.auth.event.LoginTypeEvent;
import com.alinesno.infra.base.identity.auth.event.PublishService;
import com.alinesno.infra.base.identity.entity.LoginRecordEntity;
import com.dtflys.forest.Forest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

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
//			return new ModelAndView("sa-login.html");
            return new ModelAndView("index.html");
        });

        // 配置：登录处理函数
        sso.setDoLoginHandle((name, pwd) -> {

            log.debug("name = {} , pwd = {}" , name , pwd);

            List<String> paramNames = SaHolder.getRequest().getParamNames() ;
            log.debug("paramNames = {}" , paramNames);

            LoginUser loginUser = LoginUser.convertParamListToUser(SaHolder.getRequest()) ;

            log.debug("loginUser = {}" , loginUser) ;

            LoginParamDto dto = new LoginParamDto() ;

            dto.setUsername(loginUser.getUsername());
            dto.setPassword(loginUser.getPassword());

            ManagerAccountDto accountDto = accountConsumer.loginAccount(dto) ;
            log.debug("accountDto = {}" , accountDto);

            // 此处仅做模拟登录，真实环境应该查询数据进行登录
            StpUtil.login(accountDto.getId());

            log.debug("isLogin = {}" , StpUtil.isLogin());

            // 登陆成功记录
            loginRecord() ;

            return SaResult.ok("登录成功！").setData(StpUtil.getTokenValue());
        });

        // 配置 Http 请求处理器 （在模式三的单点注销功能下用到，如不需要可以注释掉）
        sso.setSendHttp(url -> {
            try {
                // 发起 http 请求
                System.out.println("------ 发起请求：" + url);
                return Forest.get(url).executeAsString();
            } catch (Exception e) {
                log.error("发起请求异常:{}" , e.getMessage());
                return null;
            }
        });
    }

    /**
     * 用户登陆成功记录
     */
    private void loginRecord() {
        LoginRecordEntity dto = new LoginRecordEntity() ;

        final LoginRecordEvent userEvent = new LoginRecordEvent(dto);
        publishService.pub(userEvent);
    }

//    /**
//     * 注册 [Sa-Token全局过滤器]
//     */
//    @Bean
//    public SaServletFilter getSaServletFilter() {
//        return new SaServletFilter()
//
//                // 指定 拦截路由 与 放行路由
//                .addInclude("/**").addExclude("/favicon.ico")    /* 排除掉 /favicon.ico */
//
//                // 认证函数: 每次请求执行
//                .setAuth(obj -> {
//                    System.out.println("---------- 进入Sa-Token全局认证 -----------");
//
//                    // 登录认证 -- 拦截所有路由，并排除/user/doLogin 用于开放登录
//                    SaRouter.match("/**", "/user/doLogin", StpUtil::checkLogin);
//
//                    // 更多拦截处理方式，请参考“路由拦截式鉴权”章节 */
//                })
//
//                // 异常处理函数：每次认证函数发生异常时执行此函数
//                .setError(e -> {
//                    System.out.println("---------- 进入Sa-Token异常处理 -----------");
//                    return SaResult.error(e.getMessage());
//                })
//
//                // 前置函数：在每次认证函数之前执行（BeforeAuth 不受 includeList 与 excludeList 的限制，所有请求都会进入）
//                .setBeforeAuth(r -> {
//                    // ---------- 设置一些安全响应头 ----------
//                    SaHolder.getResponse()
//                            // 服务器名称
//                            .setServer("sa-server")
//                            // 是否可以在iframe显示视图： DENY=不可以 | SAMEORIGIN=同域下可以 | ALLOW-FROM uri=指定域名下可以
//                            .setHeader("X-Frame-Options", "SAMEORIGIN")
//                            // 是否启用浏览器默认XSS防护： 0=禁用 | 1=启用 | 1; mode=block 启用, 并在检查到XSS攻击时，停止渲染页面
//                            .setHeader("X-XSS-Protection", "1; mode=block")
//                            // 禁用浏览器内容嗅探
//                            .setHeader("X-Content-Type-Options", "nosniff")
//                    ;
//                })
//                ;
//    }

}
