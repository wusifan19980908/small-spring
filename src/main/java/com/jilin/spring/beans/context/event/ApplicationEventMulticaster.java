package com.jilin.spring.beans.context.event;

import com.jilin.spring.beans.context.ApplicationEvent;
import com.jilin.spring.beans.context.ApplicationListener;

/**
 * @Classname ApplicationEventMulticaster
 * @Description TODO
 * @Date 2022/2/24 11:39
 * @Created by jilin
 */
public interface ApplicationEventMulticaster {
    /**
     * 添加监听器
     * @param listener
     */
    void  addApplicationListener(ApplicationListener<?> listener);

    /**
     * 移除监听器
     * @param listener
     */
    void removeApplicationListener(ApplicationListener<?> listener);

    /**
     * 广播事件
     * @param event
     */
    void multicastEvent(ApplicationEvent event);
}
