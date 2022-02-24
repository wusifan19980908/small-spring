package com.jilin.spring.beans.context.event;

import com.jilin.spring.beans.context.ApplicationEvent;

/**
 * @Classname ContextClosedEvent
 * @Description TODO
 * @Date 2022/2/24 11:39
 * @Created by jilin
 */
public class ContextClosedEvent extends ApplicationEvent {
    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public ContextClosedEvent(Object source) {
        super(source);
    }
}
