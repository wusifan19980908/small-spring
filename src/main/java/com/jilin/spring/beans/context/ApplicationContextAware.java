package com.jilin.spring.beans.context;

import com.jilin.spring.beans.BeansException;
import com.jilin.spring.beans.factory.Aware;

/**
 * @Classname ApplicationContextAware
 * @Description TODO
 * @Date 2022/2/23 14:08
 * @Created by jilin
 */
public interface ApplicationContextAware extends Aware {
    /**
     * 实现此接口能感知到所属的ApplicationContext
     * @param applicationContext
     * @throws BeansException
     */
    void setApplicationContext(ApplicationContext applicationContext)throws BeansException;
}
