package com.jilin.spring.beans.factory;

/**
 * @Classname BeanClassLoaderAware
 * @Description TODO
 * @Date 2022/2/23 11:56
 * @Created by jilin
 */
public interface BeanClassLoaderAware extends Aware{
    /**
     * 实现此接口，能感知到所属的ClassLoader
     * @param classLoader
     */
    void setBeanClassLoader(ClassLoader classLoader);
}
