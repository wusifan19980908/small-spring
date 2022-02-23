package com.jilin.spring.beans.factory;

/**
 * @Classname InitializingBean
 * @Description TODO
 * @Date 2022/2/23 9:59
 * @Created by jilin
 */
public interface InitializingBean {
    /**
     * bean处理属性填充后调用
     * @throws Exception
     */
    void afterPropertiesSet()throws Exception;
}
