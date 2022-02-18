package com.jilin.spring.beans.core.io;

/**
 * @Classname ResourceLoader
 * @Description 资源加载接口
 * @Date 2022/2/18 16:01
 * @Created by jilin
 */
public interface ResourceLoader {
    /**
     * 本地classpath前缀
     */
    String CLASSPATH_URL_PREFIX = "classpath:";

    /**
     * 获取资源
     * @param location
     * @return
     */
    Resource getResource(String location);
}
