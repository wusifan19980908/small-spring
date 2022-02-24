package com.jilin.spring.beans.test;

import com.jilin.spring.beans.BeansException;
import com.jilin.spring.beans.PropertyValue;
import com.jilin.spring.beans.PropertyValues;
import com.jilin.spring.beans.context.support.ClassPathXmlAppliocationContext;
import com.jilin.spring.beans.core.io.DefaultResourceLoader;
import com.jilin.spring.beans.core.io.Resource;
import com.jilin.spring.beans.factory.config.BeanDefinition;
import com.jilin.spring.beans.factory.BeanFactory;
import com.jilin.spring.beans.factory.config.BeanReference;
import com.jilin.spring.beans.factory.support.DefaultListableBeanFactory;
import com.jilin.spring.beans.factory.xml.XmlBeanDefinitionReader;
import com.jilin.spring.beans.test.bean.UserDao;
import com.jilin.spring.beans.test.bean.UserService;
import com.jilin.spring.beans.test.event.CustomEvent;
import com.jilin.spring.beans.test.processor.MyBeanFactoryPostProcessor;
import com.jilin.spring.beans.test.processor.MyBeanPostProcessor;
import org.junit.Before;
import org.junit.Test;
import org.openjdk.jol.info.ClassLayout;

/**
 * @author jilin
 * @description [类型描述]
 * @createTime 2022/2/17 9:58
 */
public class ApiTest {
    private DefaultResourceLoader resourceLoader;
        @Before
        public void init(){
            resourceLoader = new DefaultResourceLoader();
        }


        @Test
        public void test_BeanFactory() throws BeansException {
          // 初始化BenaFactory
           ClassPathXmlAppliocationContext appliocationContext = new ClassPathXmlAppliocationContext("classpath:spring.xml");
           appliocationContext.publishEvent(new CustomEvent(appliocationContext,10191290090877123L,"成功了"));

           appliocationContext.registerShutdownHook();
        }
}
