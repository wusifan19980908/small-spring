package com.jilin.spring.beans.context;

import java.util.EventListener;

/**
 * @Classname ApplicationListener
 * @Description TODO
 * @Date 2022/2/24 11:41
 * @Created by jilin
 */
public interface ApplicationListener<E extends ApplicationEvent> extends EventListener {
    /**
     * 通知
     * @param event
     */
    void onApplicationEvent(E event);
}
