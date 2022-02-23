package com.jilin.spring.beans.context.support;

import com.jilin.spring.beans.BeansException;
import com.jilin.spring.beans.context.ConfigueableApplicationContext;
import com.jilin.spring.beans.core.io.DefaultResourceLoader;
import com.jilin.spring.beans.factory.ConfigurableListableBeanFactory;
import com.jilin.spring.beans.factory.config.BeanFactoryPostProcessor;
import com.jilin.spring.beans.factory.config.BeanPostProcessor;
import com.jilin.spring.beans.factory.config.ConfigurableBeanFactory;

import java.util.Map;

/**
 * @Classname AbstractApplicationContext
 * @Description TODO
 * @Date 2022/2/21 15:52
 * @Created by jilin
 */
public abstract class AbstractApplicationContext extends DefaultResourceLoader implements ConfigueableApplicationContext {
    @Override
    public void refresh() throws BeansException {
        //1、创建BeanFactory，并加载BeanDefinition
        refreshBeanFactory();
        //2、获取beanFactory
        ConfigurableListableBeanFactory beanFactory = getBeanFactory();
        //在bean实例化之前，执行BeanFactoryPostProcessor
        invokeBeanFactoryPostProcessors(beanFactory);
        //BeanPostProcessor需要提前于其他bean对象实例化之前进行注册
        registerBeanPostProcessors(beanFactory);
        //提前实例化单例bean
        beanFactory.preInstantiateSingletons();
    }

    /**
     * 刷新BeanFactory
     * @throws BeansException
     */
    protected abstract void refreshBeanFactory()throws  BeansException;

    /**
     * 获取beanFactory
     * @return
     */
    protected abstract ConfigurableListableBeanFactory getBeanFactory();

    /**
     * 执行PostProcessors
     * @param beanFactory
     * @throws BeansException
     */
    private void invokeBeanFactoryPostProcessors(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        Map<String, BeanFactoryPostProcessor> beanFactoryPostProcessorMap = beanFactory.getBeansOfType(BeanFactoryPostProcessor.class);
        for (BeanFactoryPostProcessor beanFactoryPostProcessor: beanFactoryPostProcessorMap.values()){
            beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);
        }
    }

    /**
     * 注册PostProcessors
     * @param beanFactory
     * @throws BeansException
     */
    private void registerBeanPostProcessors(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        Map<String, BeanPostProcessor> beanPostProcessorMap = beanFactory.getBeansOfType(BeanPostProcessor.class);
        for (BeanPostProcessor beanPostProcessor:beanPostProcessorMap.values()){
            beanFactory.addBeanPostProcessor(beanPostProcessor);
        }
    }

    /**
     * 获取某一类型的bean
     * @param type
     * @param <T>
     * @return
     * @throws BeansException
     */
    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
        return getBeanFactory().getBeansOfType(type);
    }

    /**
     * 获取所有类定义的名字
     * @return
     */
    @Override
    public String[] getBeanDefinitionNames() {
        return getBeanFactory().getBeanDefinitionNames();
    }

    /**
     * 根据名字获取bean
     * @param name
     * @return
     * @throws BeansException
     */
    @Override
    public Object getBean(String name) throws BeansException {
        return getBeanFactory().getBean(name);
    }

    /**
     * 获取bean
     * @param name
     * @param args
     * @return
     * @throws BeansException
     */
    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return getBeanFactory().getBean(name,args);
    }

    /**
     * 根据名字和class来获取bean
     * @param name
     * @param requiredType
     * @param <T>
     * @return
     * @throws BeansException
     */
    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return getBeanFactory().getBean(name,requiredType);
    }
}
