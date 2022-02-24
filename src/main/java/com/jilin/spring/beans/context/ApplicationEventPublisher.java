package com.jilin.spring.beans.context;

/**
 * @Classname ApplicationEventPublisher
 * @Description TODO
 * @Date 2022/2/24 11:41
 * @Created by jilin
 */
public interface ApplicationEventPublisher {
    /**
     * 事件发布接口
     * @param event
     */
    void publishEvent(ApplicationEvent event);
}
