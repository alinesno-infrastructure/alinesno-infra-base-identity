package com.alinesno.infra.base.identity.auth.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.dev33.satoken.sso.SaSsoConsts;
import cn.dev33.satoken.sso.SaSsoUtil;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaFoxUtil;
import cn.dev33.satoken.util.SaResult;

/**
 * 前后台分离架构下集成SSO所需的代码 （SSO-Server端）
 * <p>（注：如果不需要前后端分离架构下集成SSO，可删除此包下所有代码）</p>
 * @author click33
 *
 */
@RestController
public class H5Controller {
	
	/**
	 * 获取 redirectUrl 
	 */
	@GetMapping("/sso/getRedirectUrl")
	private Object getRedirectUrl(String redirect, String mode, String client) {

		// 未登录情况下，返回 code=401 
		if(!StpUtil.isLogin()) {
			return SaResult.code(401);
		}

		// 模式二或模式三
		String redirectUrl = SaSsoUtil.buildRedirectUrl(StpUtil.getLoginId(), client, redirect);
		return SaResult.data(redirectUrl);
	}

	// 全局异常拦截 
	@ExceptionHandler
	public SaResult handlerException(Exception e) {
		return SaResult.error(e.getMessage());
	}
	
}
