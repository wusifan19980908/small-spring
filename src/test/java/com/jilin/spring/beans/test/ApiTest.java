package com.jilin.spring.beans.test;

import com.jilin.spring.beans.BeansException;
import com.jilin.spring.beans.factory.config.BeanDefinition;
import com.jilin.spring.beans.factory.BeanFactory;
import com.jilin.spring.beans.factory.support.DefaultListableBeanFactory;
import com.jilin.spring.beans.test.bean.UserService;
import org.junit.Test;

/**
 * @author jilin
 * @description [类型描述]
 * @createTime 2022/2/17 9:58
 */
public class ApiTest {

        @Test
        public void test_BeanFactory() throws BeansException {
                //初始化beanFactory
                DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
                //注册bean
                BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
                beanFactory.registerBeanDefinition("userService",beanDefinition);
                //第一次获取bean
                UserService userService = (UserService) beanFactory.getBean("userService");
                userService.queryUserInfo();
                //第二次获取bean，单例对象
                UserService userService_singleton = (UserService) beanFactory.getBean("userService");
                userService_singleton.queryUserInfo();
        }
}
