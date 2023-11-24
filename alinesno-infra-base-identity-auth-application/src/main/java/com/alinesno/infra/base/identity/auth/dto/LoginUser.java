package com.alinesno.infra.base.identity.auth.dto;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoginUser {

    private String loginType ;
    private String phoneNumber ;
    private String phoneCode ;
    private String username ;
    private String password ;
    private boolean rememberMe = false ;
    private String code ;
    private String uuid ;

    public static LoginUser convertParamListToUser(String paramList) {

        // 使用 Gson 解析 JSON 数组
        JsonArray jsonArray = new Gson().fromJson(paramList, JsonArray.class);

        // 提取各个字段
        String password = jsonArray.get(0).getAsString();
        String phoneNumber = jsonArray.get(1).getAsString();
        String code = jsonArray.get(2).getAsString();
        String loginType = jsonArray.get(3).getAsString();
        String phoneCode = jsonArray.get(4).getAsString();
        String uuid = jsonArray.get(5).getAsString();
        String username = jsonArray.get(6).getAsString();
        boolean rememberMe = jsonArray.size() > 7 && jsonArray.get(7) != null;

        // 打印各个字段的值
        System.out.println("password: " + password);
        System.out.println("phoneNumber: " + phoneNumber);
        System.out.println("code: " + code);
        System.out.println("loginType: " + loginType);
        System.out.println("phoneCode: " + phoneCode);
        System.out.println("uuid: " + uuid);
        System.out.println("username: " + username);

        LoginUser user = new LoginUser();
        user.setLoginType(loginType);
        user.setPhoneNumber(phoneNumber);
        user.setPhoneCode(phoneCode);
        user.setUsername(username);
        user.setPassword(password);
        user.setRememberMe(rememberMe);
        user.setCode(code);
        user.setUuid(uuid);

        return user;
    }

}
