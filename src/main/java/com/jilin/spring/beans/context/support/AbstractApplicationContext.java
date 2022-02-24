package com.jilin.spring.beans.context.support;

import com.jilin.spring.beans.BeansException;
import com.jilin.spring.beans.context.ApplicationEvent;
import com.jilin.spring.beans.context.ApplicationListener;
import com.jilin.spring.beans.context.ConfigueableApplicationContext;
import com.jilin.spring.beans.context.event.ApplicationEventMulticaster;
import com.jilin.spring.beans.context.event.ContextClosedEvent;
import com.jilin.spring.beans.context.event.ContextRefreshedEvent;
import com.jilin.spring.beans.context.event.SimpleApplicationEventMulticaster;
import com.jilin.spring.beans.core.io.DefaultResourceLoader;
import com.jilin.spring.beans.factory.ConfigurableListableBeanFactory;
import com.jilin.spring.beans.factory.config.BeanFactoryPostProcessor;
import com.jilin.spring.beans.factory.config.BeanPostProcessor;
import com.jilin.spring.beans.factory.config.ConfigurableBeanFactory;

import java.util.Collection;
import java.util.Map;

/**
 * @Classname AbstractApplicationContext
 * @Description TODO
 * @Date 2022/2/21 15:52
 * @Created by jilin
 */
public abstract class AbstractApplicationContext extends DefaultResourceLoader implements ConfigueableApplicationContext {
    /**
     * 广播bean的名字
     */
    public static final String APPLICATION_EVENT_MULTICASTER_BEAN_NAME = "applicationEventMulticaster";
    /**
     * 广播bean
     */
    private ApplicationEventMulticaster applicationEventMulticaster;

    @Override
    public void refresh() throws BeansException {
        //1、创建BeanFactory，并加载BeanDefinition
        refreshBeanFactory();
        //2、获取beanFactory
        ConfigurableListableBeanFactory beanFactory = getBeanFactory();
        //添加ApplicationContextAwareProcessor,让继承自ApplicationContextAware的Bean对象都能感知所属的ApplicationContext
        beanFactory.addBeanPostProcessor(new ApplicationmContextAwareProcessor(this));
        //在bean实例化之前，执行BeanFactoryPostProcessor
        invokeBeanFactoryPostProcessors(beanFactory);
        //BeanPostProcessor需要提前于其他bean对象实例化之前进行注册
        registerBeanPostProcessors(beanFactory);
        //初始化事件发布者
        initApplicationEventMulticaster();
        //注册事件监听器
        resgiterListener();
        //提前实例化单例bean
        beanFactory.preInstantiateSingletons();
        //发布容器刷新完成事件
        finishrefresh();
    }

    /**
     * 初始化事件发布者
     */
    private void initApplicationEventMulticaster(){
        ConfigurableListableBeanFactory beanFactory = getBeanFactory();
        applicationEventMulticaster = new SimpleApplicationEventMulticaster(beanFactory);
        beanFactory.registerSingleton(APPLICATION_EVENT_MULTICASTER_BEAN_NAME,applicationEventMulticaster);
    }

    /**
     * 注册监听器
     * @throws BeansException
     */
    private void resgiterListener() throws BeansException {
        Collection<ApplicationListener> applicationListeners = getBeansOfType(ApplicationListener.class).values();
        for (ApplicationListener listener:applicationListeners){
            applicationEventMulticaster.addApplicationListener(listener);
        }
    }

    /**
     * 发布容器刷新完成事件
     */
    private void finishrefresh() {
        publishEvent(new ContextRefreshedEvent(this));
    }

    /**
     * 广播事件
     * @param event
     */
    @Override
    public void publishEvent(ApplicationEvent event){
        applicationEventMulticaster.multicastEvent(event);
    }

    /**
     * 注册关闭虚拟机钩子
     */
    @Override
    public void registerShutdownHook() {
        Runtime.getRuntime().addShutdownHook(new Thread(this::close));
    }

    @Override
    public void close(){
        //发布容器关闭事件
        publishEvent(new ContextClosedEvent(this));
        //销毁单例bean
        getBeanFactory().destorySingletons();
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
