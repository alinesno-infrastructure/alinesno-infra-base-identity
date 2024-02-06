package com.alinesno.infra.base.identity.auth.dto;

import cn.dev33.satoken.context.model.SaRequest;
import com.alibaba.fastjson.JSONObject;
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

        LoginUser user = JSONObject.parseObject(request.getParamNames().get(0) , LoginUser.class) ;
        log.debug("jsonObject = {}" , user);

        return user;
    }

}
