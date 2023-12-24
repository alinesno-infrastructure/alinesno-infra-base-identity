package com.alinesno.infra.base.identity.auth.config;

import cn.dev33.satoken.config.SaSsoConfig;
import cn.dev33.satoken.context.SaHolder;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
<<<<<<< HEAD
import com.alinesno.infra.base.authority.gateway.dto.ManagerAccountDto;
import com.alinesno.infra.base.identity.adapter.AccountConsumer;
import com.alinesno.infra.base.identity.adapter.dto.LoginParamDto;
import com.alinesno.infra.base.identity.auth.dto.LoginUser;
import com.dtflys.forest.Forest;
import lombok.extern.slf4j.Slf4j;
=======
import com.alinesno.infra.base.identity.auth.dto.LoginUser;
import com.dtflys.forest.Forest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
>>>>>>> 43b05c79e94b3cd7c94301179a12fed265cba633
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Component
@Slf4j
public class SaTokenConfig {

<<<<<<< HEAD
    @Autowired
    private AccountConsumer accountConsumer ;

=======
>>>>>>> 43b05c79e94b3cd7c94301179a12fed265cba633
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

<<<<<<< HEAD
            log.debug("name = {} , pwd = {}" , name , pwd);

=======
>>>>>>> 43b05c79e94b3cd7c94301179a12fed265cba633
            List<String> paramNames = SaHolder.getRequest().getParamNames() ;
            log.debug("paramNames = {}" , paramNames);

            LoginUser loginUser = LoginUser.convertParamListToUser(paramNames.toString()) ;

            log.debug("loginUser = {}" , loginUser) ;

<<<<<<< HEAD
            LoginParamDto dto = new LoginParamDto() ;

            dto.setUsername(loginUser.getUsername());
            dto.setPassword(loginUser.getPassword());

            ManagerAccountDto accountDto = accountConsumer.loginAccount(dto) ;
            log.debug("accountDto = {}" , accountDto);

            // 此处仅做模拟登录，真实环境应该查询数据进行登录
            StpUtil.login(accountDto.getId());
=======
            // 此处仅做模拟登录，真实环境应该查询数据进行登录
            StpUtil.login(10001);
>>>>>>> 43b05c79e94b3cd7c94301179a12fed265cba633

            log.debug("isLogin = {}" , StpUtil.isLogin());

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
