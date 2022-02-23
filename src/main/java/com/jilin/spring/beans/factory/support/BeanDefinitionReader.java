package com.jilin.spring.beans.factory.support;

import com.jilin.spring.beans.BeansException;
import com.jilin.spring.beans.core.io.Resource;
import com.jilin.spring.beans.core.io.ResourceLoader;

/**
 * @Classname BeanDefinitionReader
 * @Description bean读取接口
 * @Date 2022/2/18 15:57
 * @Created by jilin
 */
public interface BeanDefinitionReader {
    /**
     * 获取BeanDefinitionRegistry
     * @return
     */
    BeanDefinitionRegistry getRegister();

    /**
     * 获取资源加载器
     * @return
     */
    ResourceLoader getResourceLoader();

    /**
     * 加载资源文件
     * @param resource
     * @throws BeansException
     */
    void loadBeanDefinitions(Resource resource)throws BeansException;
    /**
     * 加载资源文件
     * @param resources
     * @throws BeansException
     */
    void loadBeanDefinitions(Resource...resources)throws BeansException;
    /**
     * 加载资源文件
     * @param location
     * @throws BeansException
     */
    void loadBeanDefinitions(String location)throws BeansException;

    void loadBeanDefinitions(String... locations)throws BeansException;
}
