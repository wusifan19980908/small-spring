package com.jilin.spring.beans.test.event;

import com.jilin.spring.beans.context.event.ApplicationContextEvent;

/**
 * @Classname CustomEvent
 * @Description TODO
 * @Date 2022/2/24 15:25
 * @Created by jilin
 */
public class CustomEvent extends ApplicationContextEvent {
    private Long id;
    private String message;

    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public CustomEvent(Object source,Long id,String message) {
        super(source);
        this.id = id;
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
