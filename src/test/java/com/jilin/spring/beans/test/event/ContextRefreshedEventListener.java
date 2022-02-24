package com.jilin.spring.beans.test.event;

import com.jilin.spring.beans.context.ApplicationListener;
import com.jilin.spring.beans.context.event.ContextRefreshedEvent;

/**
 * @Classname ContextRefreshedEventListener
 * @Description TODO
 * @Date 2022/2/24 15:31
 * @Created by jilin
 */
public class ContextRefreshedEventListener implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("刷新事件："+this.getClass().getName());
    }
}
