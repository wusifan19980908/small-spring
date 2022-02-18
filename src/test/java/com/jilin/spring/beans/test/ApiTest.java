package com.jilin.spring.beans.test;

import com.jilin.spring.beans.BeansException;
import com.jilin.spring.beans.PropertyValue;
import com.jilin.spring.beans.PropertyValues;
import com.jilin.spring.beans.core.io.DefaultResourceLoader;
import com.jilin.spring.beans.core.io.Resource;
import com.jilin.spring.beans.factory.config.BeanDefinition;
import com.jilin.spring.beans.factory.BeanFactory;
import com.jilin.spring.beans.factory.config.BeanReference;
import com.jilin.spring.beans.factory.support.DefaultListableBeanFactory;
import com.jilin.spring.beans.factory.xml.XmlBeanDefinitionReader;
import com.jilin.spring.beans.test.bean.UserDao;
import com.jilin.spring.beans.test.bean.UserService;
import org.junit.Before;
import org.junit.Test;

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
           //初始化BeanFactory
            DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
            //读取配置文件
            XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
            reader.loadBeanDefinitions("classpath:spring.xml");

            //获取bean
            UserService userService = beanFactory.getBean("userService",UserService.class);

            userService.queryUserInfo();
        }
}
