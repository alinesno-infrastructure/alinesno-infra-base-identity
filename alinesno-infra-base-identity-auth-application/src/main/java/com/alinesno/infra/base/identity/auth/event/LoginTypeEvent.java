package com.alinesno.infra.base.identity.auth.event;

import com.alinesno.infra.base.identity.entity.LoginEventEntity;
import com.alinesno.infra.base.identity.entity.LoginRecordEntity;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class LoginTypeEvent extends ApplicationEvent {

    private final LoginEventEntity loginEvent ;

    public LoginTypeEvent(LoginEventEntity loginEvent) {
        super(loginEvent);
        this.loginEvent = loginEvent;
    }

}