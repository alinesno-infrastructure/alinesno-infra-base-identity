package com.alinesno.infra.base.identity.auth.dto;

import cn.dev33.satoken.context.model.SaRequest;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.Objects;

@Slf4j
@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoginUser {

    private String loginType;
    private String phoneNumber;
    private String phoneCode;
    private String username;
    private String password;
    private boolean rememberMe = false;
    private String code;
    private String uuid;

    private static Gson gson = new Gson();

    public static LoginUser convertParamListToUser(SaRequest request) {

        log.debug("loginType = {}" , request.getParam("loginType")) ;

        // 获取参数值
        String loginType = request.getParam("loginType");
        String phoneNumber = request.getParam("phoneNumber");
        String phoneCode = request.getParam("phoneCode");
        String username = request.getParam("username");
        String password = request.getParam("password");
        String code = request.getParam("code");
        boolean rememberMe = Boolean.parseBoolean(request.getParam("rememberMe"));
        String uuid = request.getParam("uuid");

        // 输出参数值
        System.out.println("loginType: " + loginType);
        System.out.println("phoneNumber: " + phoneNumber);
        System.out.println("phoneCode: " + phoneCode);
        System.out.println("username: " + username);
        System.out.println("password: " + password);
        System.out.println("code: " + code);
        System.out.println("uuid: " + uuid);

        LoginUser user = new LoginUser();
        user.setLoginType(loginType);
        user.setPhoneNumber(phoneNumber);
        user.setPhoneCode(phoneCode);

        if (Objects.equals(loginType, "sms")) {
            user.setUsername(phoneNumber);
            user.setPassword(phoneCode);
        } else {
            user.setUsername(username);
            user.setPassword(password);
        }

        user.setRememberMe(rememberMe);
        user.setCode(code);
        user.setUuid(uuid);

        return user;
    }

}
