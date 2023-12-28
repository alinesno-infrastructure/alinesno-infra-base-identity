package com.alinesno.infra.base.identity.auth.event;

import com.alinesno.infra.base.identity.adapter.LoginEventConsumer;
import com.alinesno.infra.base.identity.entity.LoginEventEntity;
import com.alinesno.infra.base.identity.entity.LoginRecordEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class GeneralEventListener implements ApplicationListener<ApplicationEvent> {

    @Autowired
    private LoginEventConsumer loginEventConsumer ;

    @Override
    public void onApplicationEvent(ApplicationEvent event) {

        log.warn("GeneralEventListener name = {}" ,event.getClass().getSimpleName());
        if(event instanceof ContextRefreshedEvent){
            log.info("ContextRefreshedEvent execute ~~ !");
        }

        log.debug(Thread.currentThread().getName()+" , GeneralEventListener userName="+event.getSource());

        if(event instanceof LoginTypeEvent){
            loginEventConsumer.eventRecord((LoginEventEntity) event.getSource()) ;
        }else if(event instanceof LoginRecordEvent){
            loginEventConsumer.loginRecord((LoginRecordEntity) event.getSource()); ;
        }

    }
}