package com.jilin.spring.beans.test;

import com.jilin.spring.aop.AdvisedSupport;
import com.jilin.spring.aop.MethodMatcher;
import com.jilin.spring.aop.TargetSource;
import com.jilin.spring.aop.aspectj.AspectJExpressionPointcut;
import com.jilin.spring.aop.framework.Cglib2AopProxy;
import com.jilin.spring.aop.framework.JdkDynamicAopProxy;
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
import com.jilin.spring.beans.test.bean.IUserDao;
import com.jilin.spring.beans.test.bean.IUserService;
import com.jilin.spring.beans.test.bean.UserDao;
import com.jilin.spring.beans.test.bean.UserService;
import com.jilin.spring.beans.test.event.CustomEvent;
import com.jilin.spring.beans.test.interceptor.UserServiceInterceptor;
import com.jilin.spring.beans.test.processor.MyBeanFactoryPostProcessor;
import com.jilin.spring.beans.test.processor.MyBeanPostProcessor;
import org.junit.Before;
import org.junit.Test;
import org.openjdk.jol.info.ClassLayout;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

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

        @Test
        public void test_proxy_method(){
            //目标对象
            IUserService userService = new UserService();
            //组装代理信息
            AdvisedSupport advisedSupport = new AdvisedSupport();
            advisedSupport.setTargetSource(new TargetSource(userService));
            advisedSupport.setMethodInterceptor(new UserServiceInterceptor());
            advisedSupport.setMethodMatcher(new AspectJExpressionPointcut("execution(* com.jilin.spring.beans.test.bean.IUserService.*(..))"));

            //代理对象
            IUserService proxy_jdk = (IUserService) new JdkDynamicAopProxy(advisedSupport).getProxy();
            //测试调用
            System.out.println("测试结果：");
            proxy_jdk.queryUserName();
            //代理对象
            IUserService proxy_cglib = (IUserService) new Cglib2AopProxy(advisedSupport).getProxy();
            System.out.println("测试结果：");
            System.out.println(proxy_cglib.register("花花"));
        }
}
