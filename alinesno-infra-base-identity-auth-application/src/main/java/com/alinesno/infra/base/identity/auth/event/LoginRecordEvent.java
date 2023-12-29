package com.alinesno.infra.base.identity.auth.event;

import com.alinesno.infra.base.identity.entity.LoginRecordEntity;
import lombok.Getter;

@Getter
public class LoginRecordEvent extends BaseEvent {

    private final LoginRecordEntity loginEvent ;

    public LoginRecordEvent(LoginRecordEntity loginEvent) {
        super(loginEvent);
        this.loginEvent = loginEvent;
    }

}