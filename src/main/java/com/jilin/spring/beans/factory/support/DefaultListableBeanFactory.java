package com.jilin.spring.beans.factory.support;

import com.jilin.spring.beans.BeansException;
import com.jilin.spring.beans.factory.config.BeanDefinition;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jilin
 * @description 最终实现类，负责注册beanDefinition和获取beanDefinition的细节
 * @createTime 2022/2/17 10:22
 */
public class DefaultListableBeanFactory extends AbstractAutoWireCapableBeanFactory implements BeanDefinitionRegistry{
    /**
     * 存储注册的beanDefinition
     */
    private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

    /**
     * 注册beanDefinition
     * @param beanName bean 名字
     * @param beanDefinition bean信息
     */
    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName,beanDefinition);
    }

    /**
     * 获取beanDefinition
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public BeanDefinition getBeanDefinition(String beanName) throws BeansException {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if (beanDefinition==null){
            throw new BeansException("没有找到beanname:"+beanName);
        }
        return beanDefinition;
    }

    /**
     * 判断是否包含指定名称的BeanDefinition
     * @param beanName
     * @return
     */
    @Override
    public boolean containsBeanDefinition(String beanName) {
        return beanDefinitionMap.containsKey(beanName);
    }

    @Override
    public String[] getBeanDefinitionNames() {
        return new String[0];
    }


}
