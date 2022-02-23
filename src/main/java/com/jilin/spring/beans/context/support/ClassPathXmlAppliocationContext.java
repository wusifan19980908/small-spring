package com.jilin.spring.beans.context.support;

import com.jilin.spring.beans.BeansException;

/**
 * @Classname ClassPathXmlAppliocationContext
 * @Description TODO
 * @Date 2022/2/21 15:53
 * @Created by jilin
 */
public class ClassPathXmlAppliocationContext extends AbstractXmlApplicationContext{
    private String[] configLocations;

    /**
     * 从xml中加载Beandefinition，并刷新上下文
     * @param configLocations
     * @throws BeansException
     */
    public ClassPathXmlAppliocationContext(String configLocations)throws BeansException{
        this(new String[]{configLocations});
    }

    /**
     * 从xml中加载Beandefinition，并刷新上下文
     * @param configLocations
     * @throws BeansException
     */
    public ClassPathXmlAppliocationContext(String[] configLocations)throws BeansException{
        this.configLocations = configLocations;
        refresh();
    }

    @Override
    protected String[] getConfigLocations() {
        return configLocations;
    }
}
