package com.alinesno.infra.base.identity.auth.config;

import cn.dev33.satoken.config.SaSsoConfig;
import cn.dev33.satoken.context.SaHolder;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import com.alinesno.infra.base.identity.auth.dto.LoginUser;
import com.dtflys.forest.Forest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Component
@Slf4j
public class SaTokenConfig {

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

            List<String> paramNames = SaHolder.getRequest().getParamNames() ;
            log.debug("paramNames = {}" , paramNames);

            LoginUser loginUser = LoginUser.convertParamListToUser(paramNames.toString()) ;

            log.debug("loginUser = {}" , loginUser) ;

            name = loginUser.getUsername() ;
            pwd = loginUser.getPassword() ;

            // 此处仅做模拟登录，真实环境应该查询数据进行登录
            StpUtil.login(10001);
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

}
