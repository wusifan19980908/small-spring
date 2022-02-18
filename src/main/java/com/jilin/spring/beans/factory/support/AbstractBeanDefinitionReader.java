package com.jilin.spring.beans.factory.support;

import com.jilin.spring.beans.core.io.DefaultResourceLoader;
import com.jilin.spring.beans.core.io.ResourceLoader;

/**
 * @Classname AbstractBeanDefinitionReader
 * @Description TODO
 * @Date 2022/2/18 15:56
 * @Created by jilin
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {
    /**
     * 类注册
     */
    private final BeanDefinitionRegistry registry;
    /**
     * 资源加载器
     */
    private ResourceLoader resourceLoader;

    /**
     * 注册器构造方法
     * @param registry
     */
    public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry) {
        this(registry,new DefaultResourceLoader());
    }
    /**
     * 全参构造方法
     * @param registry
     * @param resourceLoader
     */
    public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        this.registry = registry;
        this.resourceLoader = resourceLoader;
    }

    /**
     * 获取注册器
     * @return
     */
    @Override
    public BeanDefinitionRegistry getRegister() {
        return registry;
    }

    /**
     * 获取资源加载器
     * @return
     */
    @Override
    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }
}
