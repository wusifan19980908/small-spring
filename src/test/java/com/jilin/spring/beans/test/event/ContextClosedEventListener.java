package com.jilin.spring.beans.test.event;

import com.jilin.spring.beans.context.ApplicationListener;
import com.jilin.spring.beans.context.event.ContextClosedEvent;

/**
 * @Classname ContextClosedEventListener
 * @Description TODO
 * @Date 2022/2/24 15:30
 * @Created by jilin
 */
public class ContextClosedEventListener implements ApplicationListener<ContextClosedEvent> {
    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        System.out.println("关闭事件:"+this.getClass().getName());
    }
}
