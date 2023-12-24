package com.alinesno.infra.base.identity.auth.dto;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
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
            JSONArray jsonArray = JSONArray.parseArray(paramList) ;
            JSONObject jsonObject = jsonArray.getJSONObject(0);

            String loginType = jsonObject.getString("loginType");
            String phoneNumber = jsonObject.getString("phoneNumber");
            String phoneCode = jsonObject.getString("phoneCode");
            String username = jsonObject.getString("username");
            String password = jsonObject.getString("password");
            boolean rememberMe = jsonObject.get("rememberMe") != null ? jsonObject.getBoolean("rememberMe"):false;
            String code = jsonObject.getString("code");
            String uuid = jsonObject.getString("uuid");

            LoginUser user = new LoginUser();
            user.setLoginType(loginType);
            user.setPhoneNumber(phoneNumber);
            user.setPhoneCode(phoneCode);

            if(loginType.equals("sms")){
                user.setUsername(phoneNumber);
                user.setPassword(phoneCode);
            }else{
                user.setUsername(username);
                user.setPassword(password);
            }

            user.setRememberMe(rememberMe);
            user.setCode(code);
            user.setUuid(uuid);

            return user;
    }

}
