package com.alinesno.infra.base.identity.auth.event;

import org.springframework.context.ApplicationEvent;

import java.util.EventListener;

@FunctionalInterface
public interface ApplicationListener<E extends ApplicationEvent> extends EventListener {
   /**
    * Handle an application event.
    * @param event the event to respond to
    */
   void onApplicationEvent(E event);
}