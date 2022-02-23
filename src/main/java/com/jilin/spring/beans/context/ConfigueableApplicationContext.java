package com.jilin.spring.beans.context;

import com.jilin.spring.beans.BeansException;

/**
 * @Classname ConfigueableApplicationContext
 * @Description TODO
 * @Date 2022/2/21 15:54
 * @Created by jilin
 */
public interface ConfigueableApplicationContext extends ApplicationContext {

    /**
     * 刷新容器
     * @throws BeansException
     */
    void refresh()throws BeansException;

    /**
     * 注册销毁bean的hook
     */
    void registerShutdownHook();

    /**
     * 手动关闭
     */
    void close() throws BeansException;
}
