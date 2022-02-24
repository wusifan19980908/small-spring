package com.jilin.spring.beans.context;

import com.jilin.spring.beans.core.io.ResourceLoader;
import com.jilin.spring.beans.factory.HierarchicalBeanFactory;
import com.jilin.spring.beans.factory.ListableBeanFactory;

/**
 * @Classname ApplicationContext
 * @Description 上下文接口
 * @Date 2022/2/21 15:53
 * @Created by jilin
 */
public interface ApplicationContext extends ListableBeanFactory, HierarchicalBeanFactory, ResourceLoader,ApplicationEventPublisher {
}
