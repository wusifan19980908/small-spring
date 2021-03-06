package com.jilin.spring.beans.factory.support;

import com.jilin.spring.beans.BeansException;
import com.jilin.spring.beans.factory.BeanFactory;
import com.jilin.spring.beans.factory.FactoryBean;
import com.jilin.spring.beans.factory.config.BeanDefinition;
import com.jilin.spring.beans.factory.config.BeanPostProcessor;
import com.jilin.spring.beans.factory.config.ConfigurableBeanFactory;
import com.jilin.spring.beans.util.ClassUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jilin
 * @description 模板类，实现获取bean的方法，同时定义getBean方法的执行顺序
 * @createTime 2022/2/17 10:22
 */
public abstract class AbstractBeanFactory extends FactoryBeanRegistrySupport implements ConfigurableBeanFactory {
    /**
     * 获取默认的类加载器
     */
    private ClassLoader beanClassLoader = ClassUtils.getDefaultClassLoader();

    /**
     * beanPostProcessors集合
     */
    private final List<BeanPostProcessor> beanPostProcessors = new ArrayList<>();



    @Override
    public Object getBean(String name){
        try {
            return doGetBean(name,null);
        } catch (BeansException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return doGetBean(name,args);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return (T) getBean(name);
    }

    /**
     * 获取bean
     * @param name
     * @param args
     * @param <T>
     * @return
     * @throws BeansException
     */
    protected <T> T doGetBean(final String name, final Object[] args) throws BeansException {
        Object sharedInstance = getSingleton(name);
        if (sharedInstance!=null){
            //如果是FactoryBean 则需要调用FactoryBean#getObject
            return (T) getObjectForBeanInstance(sharedInstance,name);
        }
        //如果获取为空，则先实例化
        BeanDefinition beanDefinition = getBeanDefinition(name);

        Object bean = createBean(name,beanDefinition,args);
        return (T) getObjectForBeanInstance(bean,name);

    }

    /**
     * 获取对象实例
     * @param beanInstance
     * @param beanName
     * @return
     * @throws BeansException
     */
    private Object getObjectForBeanInstance(Object beanInstance,String beanName) throws BeansException {
        if (!(beanInstance instanceof FactoryBean)){
            return beanInstance;
        }
        Object object = getCachedObjectForFactoryBean(beanName);
        if (object==null){
            FactoryBean<?> factoryBean = (FactoryBean<?>) beanInstance;
            object = getObjectFromFactoryBean(factoryBean,beanName);
        }
        return object;
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    /**
     * 实例化bean
     * @param beanName
     * @param beanDefinition
     * @param args
     * @return
     * @throws BeansException
     */
    protected abstract Object createBean(String beanName,BeanDefinition beanDefinition,Object[] args)throws BeansException;

    /**
     * 添加BeanPostProcessor
     * @param beanPostProcessor
     */
    @Override
    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) {
        this.beanPostProcessors.remove(beanPostProcessor);
        this.beanPostProcessors.add(beanPostProcessor);
    }

    /**
     * 获取所有的BeanPostProcessor
     * @return
     */
    public List<BeanPostProcessor> getBeanPostProcessors() {
        return beanPostProcessors;
    }

    public ClassLoader getBeanClassLoader() {
        return beanClassLoader;
    }
}
