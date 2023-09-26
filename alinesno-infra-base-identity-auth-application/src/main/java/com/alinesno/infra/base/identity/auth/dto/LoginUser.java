package com.alinesno.infra.base.identity.auth.dto;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
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
    private boolean rememberMe ;
    private String code ;
    private String uuid ;

    public static LoginUser convertParamListToUser(String paramList) throws JSONException {

        JSONArray jsonArray = JSONArray.parseArray(paramList) ;
        JSONObject jsonObject = jsonArray.getJSONObject(0);

        String username = jsonObject.getString("username");
        String password = jsonObject.getString("password");
        String code = jsonObject.getString("code");

        LoginUser user = new LoginUser();
        user.setUsername(username);
        user.setPassword(password);
        user.setCode(code);

        return user;
    }


}
