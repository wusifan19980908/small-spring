package com.jilin.spring.beans.context.support;

import com.jilin.spring.beans.BeansException;
import com.jilin.spring.beans.factory.support.DefaultListableBeanFactory;
import com.jilin.spring.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @Classname AbstractXmlApplicationContext
 * @Description TODO
 * @Date 2022/2/21 15:52
 * @Created by jilin
 */
public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext{
    /**
     * 加载bean信息
     * @param beanFactory
     * @throws BeansException
     */
    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) throws BeansException {
        //获取xml文件
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory,this);
        //获取配置文件路径
        String[] configLocations = getConfigLocations();
        if (null!=configLocations){
            //加载配置文件
            beanDefinitionReader.loadBeanDefinitions(configLocations);
        }
    }

    /**
     * 获取配置路径
     * @return
     */
    protected abstract String[] getConfigLocations();
}
