package com.alinesno.infra.base.identity.auth.event;

import com.alinesno.infra.base.identity.entity.LoginEventEntity;
import com.alinesno.infra.base.identity.entity.LoginRecordEntity;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class LoginRecordEvent extends ApplicationEvent {

    private final LoginRecordEntity loginEvent ;

    public LoginRecordEvent(LoginRecordEntity loginEvent) {
        super(loginEvent);
        this.loginEvent = loginEvent;
    }

}