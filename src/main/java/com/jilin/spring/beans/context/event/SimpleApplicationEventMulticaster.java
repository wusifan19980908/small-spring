package com.jilin.spring.beans.context.event;

import com.jilin.spring.beans.context.ApplicationEvent;
import com.jilin.spring.beans.context.ApplicationListener;
import com.jilin.spring.beans.factory.BeanFactory;

/**
 * @Classname SimpleApplicationEventMulticaster
 * @Description TODO
 * @Date 2022/2/24 11:40
 * @Created by jilin
 */
public class SimpleApplicationEventMulticaster extends AbstractApplicationEventMulicaster{

    public SimpleApplicationEventMulticaster(BeanFactory beanFactory) {
        setBeanFactory(beanFactory);
    }

    /**
     * 通知事件
     * @param event
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    @Override
    public void multicastEvent(final ApplicationEvent event){
       try{
           for (final ApplicationListener listener:getApplicationListener(event)){
               listener.onApplicationEvent(event);
           }
       }catch (Exception e){
           e.printStackTrace();
       }
    }
}
