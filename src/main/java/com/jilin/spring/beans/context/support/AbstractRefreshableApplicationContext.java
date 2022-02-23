package com.jilin.spring.beans.context.support;

import com.jilin.spring.beans.BeansException;
import com.jilin.spring.beans.factory.support.DefaultListableBeanFactory;

/**
 * @Classname AbstractRefreshableApplicationContext
 * @Description TODO
 * @Date 2022/2/21 15:52
 * @Created by jilin
 */
public abstract class AbstractRefreshableApplicationContext extends AbstractApplicationContext{
    private DefaultListableBeanFactory beanFactory;

    /**
     * 刷新BeanFactory
     * @throws BeansException
     */
    @Override
    protected void refreshBeanFactory() throws BeansException {
        //创建beanFactory
        DefaultListableBeanFactory beanFactory = createBeanFactory();
        //加载bean信息
        loadBeanDefinitions(beanFactory);
        this.beanFactory = beanFactory;
    }

    /**
     * 创建BeanFacyory
     * @return
     */
    private DefaultListableBeanFactory createBeanFactory(){
        return new DefaultListableBeanFactory();
    }

    /**
     * 加载bean信息
     * @param beanFactory
     * @throws BeansException
     */
    protected abstract  void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) throws BeansException;

    /**
     * 获取beanFactory
     * @return
     */
    @Override
    public DefaultListableBeanFactory getBeanFactory() {
        return beanFactory;
    }
}
