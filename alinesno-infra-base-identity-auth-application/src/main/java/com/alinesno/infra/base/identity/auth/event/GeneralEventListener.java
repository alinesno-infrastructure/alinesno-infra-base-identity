package com.alinesno.infra.base.identity.auth.event;

import com.alinesno.infra.base.identity.adapter.LoginEventConsumer;
import com.alinesno.infra.base.identity.api.AuthWebLogDto;
import com.alinesno.infra.base.identity.entity.LoginEventEntity;
import com.alinesno.infra.base.identity.entity.LoginRecordEntity;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class GeneralEventListener implements ApplicationListener<BaseEvent> {

    @Autowired
    private LoginEventConsumer loginEventConsumer ;

    @Override
    public void onApplicationEvent(@NotNull BaseEvent event) {

        log.debug("GeneralEventListener name = {}" ,event.getClass().getSimpleName());
        log.debug(Thread.currentThread().getName()+" , GeneralEventListener userName="+event.getSource());

        if(event instanceof LoginTypeEvent){
            loginEventConsumer.eventRecord((LoginEventEntity) event.getSource()) ;
        }else if(event instanceof LoginRecordEvent){
            loginEventConsumer.loginRecord((LoginRecordEntity) event.getSource()); ;
        }else if(event instanceof AuthWebLogEvent){
            log.debug("event message = {}" , event.getSource());
            loginEventConsumer.authWebLog((AuthWebLogDto)event.getSource()) ;
        }

    }
}