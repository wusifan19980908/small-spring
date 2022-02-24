package com.jilin.spring.beans.context.event;

import com.jilin.spring.beans.context.ApplicationContext;
import com.jilin.spring.beans.context.ApplicationEvent;

/**
 * @Classname ApplicationContextEvent
 * @Description TODO
 * @Date 2022/2/24 11:39
 * @Created by jilin
 */
public class ApplicationContextEvent extends ApplicationEvent {
    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public ApplicationContextEvent(Object source) {
        super(source);
    }

    /**
     * 获取上下文
     * @return
     */
    public final ApplicationContext getApplicationContext(){
        return (ApplicationContext) getSource();
    }
}
