package com.jilin.spring.beans.context.event;

/**
 * @Classname ContextRefreshedEvent
 * @Description TODO
 * @Date 2022/2/24 11:40
 * @Created by jilin
 */
public class ContextRefreshedEvent extends ApplicationContextEvent{
    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public ContextRefreshedEvent(Object source) {
        super(source);
    }
}
