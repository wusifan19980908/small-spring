package com.jilin.spring.beans.context.event;

import com.jilin.spring.beans.context.ApplicationEvent;
import com.jilin.spring.beans.context.ApplicationListener;
import com.jilin.spring.beans.factory.BeanFactory;
import com.jilin.spring.beans.factory.BeanFactoryAware;
import com.jilin.spring.beans.util.ClassUtils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @Classname AbstractApplicationEventMulicaster
 * @Description TODO
 * @Date 2022/2/24 11:39
 * @Created by jilin
 */
public abstract class AbstractApplicationEventMulicaster implements ApplicationEventMulticaster, BeanFactoryAware {
    public final Set<ApplicationListener<ApplicationEvent>> applicationListeners = new LinkedHashSet<>();
    private BeanFactory beanFactory;

    /**
     * 添加监听器
     * @param listener
     */
    @Override
    public void addApplicationListener(ApplicationListener<?> listener) {
        applicationListeners.add((ApplicationListener<ApplicationEvent>) listener);
    }

    @Override
    public void removeApplicationListener(ApplicationListener<?> listener) {
        applicationListeners.remove(listener);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    /**
     * 获取所有的监听器
     * @param event
     * @return
     * @throws Exception
     */
    protected Collection<ApplicationListener> getApplicationListener(ApplicationEvent event) throws Exception {
        LinkedList<ApplicationListener> allListeners = new LinkedList<>();
        for (ApplicationListener<ApplicationEvent> listener:applicationListeners){
            if (supportsEvent(listener,event)){
                allListeners.add(listener);
            }
        }
        return allListeners;
    }

    /**
     * 判断是否支持监听
     * @param applicationListener
     * @param event
     * @return
     * @throws Exception
     */
    protected boolean supportsEvent(ApplicationListener<ApplicationEvent> applicationListener,ApplicationEvent event) throws Exception {
        Class<? extends ApplicationListener> listenerClass = applicationListener.getClass();

        //按照 CglibSubclassingInstantiationStrategy、
        //SimpleInstantiationStrategy 不同的实例化类型，需要判断后获取目标 clas
        Class<?> targetClass = ClassUtils.isCglibProxy(listenerClass)?listenerClass.getSuperclass():listenerClass;

        Type genericInterface = targetClass.getGenericInterfaces()[0];  //返回类实现的接口
        //泛型类型
       Type actualTypeArgument = ((ParameterizedType) genericInterface).getActualTypeArguments()[0];

       String className = actualTypeArgument.getTypeName();
       Class<?> eventClassName;
       try{
           eventClassName = Class.forName(className);
       } catch (ClassNotFoundException e) {
           throw new Exception("worng event class name："+className);
       }
        // 判定此 eventClassName 对象所表示的类或接口与指定的 event.getClass() 参数所表示的类或接口是否相同，或是否是其超类或超接口。
        // isAssignableFrom 是用来判断子类和父类的关系的，或者接口的实现类和接口的关系的，默认所有的类的终极父类都是 Object。如果 A.isAssignableFrom(B)结果是 true，证明 B 可以转换成为 A,也就是 A 可以由 B 转换而来。

        return eventClassName.isAssignableFrom(event.getClass());
    }
}
