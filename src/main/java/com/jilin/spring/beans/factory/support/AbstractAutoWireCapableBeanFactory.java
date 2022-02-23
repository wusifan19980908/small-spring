package com.jilin.spring.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import com.jilin.spring.beans.BeansException;
import com.jilin.spring.beans.PropertyValue;
import com.jilin.spring.beans.PropertyValues;
import com.jilin.spring.beans.factory.BeanFactory;
import com.jilin.spring.beans.factory.config.AutowireCapableBeanFactory;
import com.jilin.spring.beans.factory.config.BeanDefinition;
import com.jilin.spring.beans.factory.config.BeanPostProcessor;
import com.jilin.spring.beans.factory.config.BeanReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Constructor;

/**
 * @author jilin
 * @description 实现  实例化bean方法抽象类
 * @createTime 2022/2/17 10:22
 */
public abstract class AbstractAutoWireCapableBeanFactory extends AbstractBeanFactory implements AutowireCapableBeanFactory {
    /**
     * 实例化策略
     */
    private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();

    /**
     *实例化注册的beanDefinition
     * @param beanName 实例化后bean的name
     * @param beanDefinition 注册的beanDefinition
     * @return
     * @throws BeansException
     */
    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition,Object[] args) throws BeansException {
        Object bean = null;
        try{
            //实例化bean
            bean = createBeanInstance(beanDefinition,beanName,args);
            System.out.printf("实例化bean--{%s}\n",beanName);
            //给bean填充数据
            applyPropertyValues(beanName,bean,beanDefinition);

            //执行bean的初始化方法和BeanPostProcessor的前置和后置处理方法
            bean = initializaBean(beanName,bean,beanDefinition);
        } catch (Exception e) {
            throw new BeansException("实例化失败",e);
        }
        //将实例化后的bean添加到单例对象map
        addSingleton(beanName,bean);
        return bean;
    }

    /**
     * 实例化bean
     * @param beanDefinition
     * @param beanName
     * @param args
     * @return
     */
    protected Object createBeanInstance(BeanDefinition beanDefinition,String beanName,Object[] args) throws BeansException {
        Constructor constructorToUse = null;
        //获取类对象
        Class<?> beanClass = beanDefinition.getBeanClass();
        //获取所有的构造方法
        Constructor<?>[] declaredConstructor  = beanClass.getDeclaredConstructors();
        //遍历寻找合适的构造方法
        for (Constructor constructor:declaredConstructor){
            //
            if (null!=args&&constructor.getParameterTypes().length==args.length){
                constructorToUse = constructor;
                break;
            }
        }
        return getInstantiationStrategy().instantiate(beanDefinition,beanName,constructorToUse,args);
    }

    /**
     * bean属性填充
     * @param beanName bean名字
     * @param bean bean对象
     * @param beanDefinition bean定义
     * @throws BeansException
     */
    protected void applyPropertyValues(String beanName,Object bean,BeanDefinition beanDefinition) throws BeansException {
        try{
            //获取定义中的属性集合
            PropertyValues propertyValues = beanDefinition.getPropertyValues();
            for (PropertyValue propertyValue:propertyValues.getPropertyValues()){
                String name = propertyValue.getName();
                Object value = propertyValue.getValue();
                //如果value是引用类型，则进行填充
                if (value instanceof BeanReference){
                    //A 依赖 B 获取B的实例化
                    BeanReference beanReference = (BeanReference) value;
                    value = getBean(beanReference.getBeanNam());
                }
                //属性填充
                BeanUtil.setFieldValue(bean,name,value);
            }
        }catch (Exception e){
            throw new BeansException("填充属性错误:"+beanName);
        }
    }



    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }

    /**
     * 实例化bean
     * @param beanName
     * @param bean
     * @param beanDefinition
     * @return
     * @throws BeansException
     */
    private Object initializaBean(String beanName,Object bean,BeanDefinition beanDefinition) throws BeansException {
        //1\执行BeanPostProcessor bfore处理
        Object wrappedBean = applyBeanPostProcessorsBeforeInitialization(bean,beanName);
        //2.待完成内容，invokeInitMethods
        invokeInitMethods(beanName,wrappedBean,beanDefinition);
        //3.执行BeanPostProcessor After处理
        wrappedBean = applyBeanPostProcessorsAfterInitialization(wrappedBean,beanName);
        return wrappedBean;
    }

    private void invokeInitMethods(String beanName,Object wrappedBean,BeanDefinition beanDefinition){

    }

    /**
     * 在实例化前操作
     * @param existingBean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName) throws BeansException {
        Object result = existingBean;
        for (BeanPostProcessor processor:getBeanPostProcessors()){
            Object current = processor.postProcessBeforeInitialization(result,beanName);
            if (null==current){
                return result;
            }
            result = current;
        }
        return result;
    }

    /**
     * 实例化后操作
     * @param existingBean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName) throws BeansException {
        Object result = existingBean;
        for (BeanPostProcessor processor: getBeanPostProcessors()){
            Object current = processor.postProcessAfterInitialization(result,beanName);
            if (null==current){
                return result;
            }
            result = current;
        }
        return result;
    }
}
