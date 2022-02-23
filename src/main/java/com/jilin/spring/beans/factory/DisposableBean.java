package com.jilin.spring.beans.factory;

/**
 * @Classname DisposableBean
 * @Description TODO
 * @Date 2022/2/23 9:59
 * @Created by jilin
 */
public interface DisposableBean {
    /**
     * 销毁
     * @throws Exception
     */
    void destory() throws Exception;
}
