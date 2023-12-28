package com.alinesno.infra.base.identity.auth.dto;

import cn.dev33.satoken.context.model.SaRequest;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;
import java.util.Objects;

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

        // 将 JSON 字符串解析为 JsonArray
        String jsonString = request.getParamNames().toString() ;
        JsonArray jsonArray = gson.fromJson(jsonString, JsonArray.class);

        // 假设 JSON 字符串中只有一个对象
        JsonObject jsonObject = jsonArray.get(0).getAsJsonObject();

        // 获取参数值
        String loginType = getStringOrNull(jsonObject, "loginType");
        String phoneNumber = getStringOrNull(jsonObject, "phoneNumber");
        String phoneCode = getStringOrNull(jsonObject, "phoneCode");
        String username = getStringOrNull(jsonObject, "username");
        String password = getStringOrNull(jsonObject, "password");
        String code = getStringOrNull(jsonObject, "code");
        boolean rememberMe = getBooleanOrNull(jsonObject, "rememberMe");
        String uuid = getStringOrNull(jsonObject, "uuid");

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

    // 辅助方法用于获取字符串值或返回 null（如果不存在或为 null）
    private static String getStringOrNull(JsonObject jsonObject, String key) {
        JsonElement element = jsonObject.get(key);
        return (element != null && !element.isJsonNull()) ? element.getAsString() : null;
    }

    // 辅助方法用于获取字符串值或返回 null（如果不存在或为 null）
    private static boolean getBooleanOrNull(JsonObject jsonObject, String key) {
        JsonElement element = jsonObject.get(key);
        return element != null && !element.isJsonNull() && element.getAsBoolean();
    }
}
