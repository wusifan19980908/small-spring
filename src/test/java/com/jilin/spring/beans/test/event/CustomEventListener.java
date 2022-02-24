package com.jilin.spring.beans.test.event;

import com.jilin.spring.beans.context.ApplicationListener;

import java.util.Date;

/**
 * @Classname CustomEventListener
 * @Description TODO
 * @Date 2022/2/24 15:27
 * @Created by jilin
 */
public class CustomEventListener implements ApplicationListener<CustomEvent> {
    @Override
    public void onApplicationEvent(CustomEvent event) {
        System.out.println("收到"+event.getSource()+"消息;时间:"+new Date());
        System.out.println("消息:"+event.getId()+":"+event.getMessage());
    }
}
