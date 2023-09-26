package com.alinesno.infra.base.identity.auth.controller;

import com.alinesno.infra.common.facade.response.AjaxResult;
import jdk.jfr.Registered;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 退出控制层
 */
@Slf4j
@RestController
public class LogoutController {

    @PostMapping("/logout")
    public AjaxResult logout(){

        log.debug("用户退出");

        return AjaxResult.success() ;
    }

}
