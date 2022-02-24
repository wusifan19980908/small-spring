package com.jilin.spring.beans.context;

import java.util.EventObject;

/**
 * @Classname ApplicationEvent
 * @Description TODO
 * @Date 2022/2/24 11:40
 * @Created by jilin
 */
public abstract class ApplicationEvent extends EventObject {

    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public ApplicationEvent(Object source) {
        super(source);
    }
}
