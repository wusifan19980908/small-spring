package com.jilin.spring.aop.framework;

/**
 * @Classname AopProxy
 * @Description 代理抽象类
 * @Date 2022/2/24 16:56
 * @Created by jilin
 */
public interface AopProxy {
    /**
     * 获取代理类
     * @return
     */
    Object getProxy();
}
