package com.jilin.spring.beans.factory.xml;

import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.XmlUtil;
import cn.hutool.json.XML;
import com.jilin.spring.beans.BeansException;
import com.jilin.spring.beans.PropertyValue;
import com.jilin.spring.beans.core.io.Resource;
import com.jilin.spring.beans.core.io.ResourceLoader;
import com.jilin.spring.beans.factory.config.BeanDefinition;
import com.jilin.spring.beans.factory.config.BeanReference;
import com.jilin.spring.beans.factory.support.AbstractBeanDefinitionReader;
import com.jilin.spring.beans.factory.support.BeanDefinitionRegistry;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Classname XmlBeanDefinitionReader
 * @Description TODO
 * @Date 2022/2/18 15:58
 * @Created by jilin
 */
public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {
    /**
     * 调用父级构造器
     * @param registry
     */
    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry) {
        super(registry);
    }

    /**
     * 调用父级构造器
     * @param registry
     * @param resourceLoader
     */
    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        super(registry, resourceLoader);
    }

    /**
     * 加载resource中的bean
     * @param resource
     * @throws BeansException
     */
    @Override
    public void loadBeanDefinitions(Resource resource) throws BeansException {
        try{
            try(InputStream inputStream = resource.getInputStream()){
                doLoadBeanDefinitions(inputStream);
            }
        }catch (IOException | ClassNotFoundException e){
            throw new BeansException("IOException parsing XML doucment from "+resource,e);
        }
    }

    /**
     * 加载多个资源文件
     * @param resources
     * @throws BeansException
     */
    @Override
    public void loadBeanDefinitions(Resource... resources) throws BeansException {
        for (Resource resource:resources){
            loadBeanDefinitions(resource);
        }
    }

    /**
     * 加载本地xml中的bean
     * @param location
     * @throws BeansException
     */
    @Override
    public void loadBeanDefinitions(String location) throws BeansException {
        ResourceLoader resourceLoader = getResourceLoader();
        Resource resource = resourceLoader.getResource(location);
        loadBeanDefinitions(resource);
    }

    /**
     * 加载xml中的bean
     * @param inputStream
     * @throws BeansException
     */
    protected void doLoadBeanDefinitions(InputStream inputStream) throws BeansException, ClassNotFoundException {
        Document document = XmlUtil.readXML(inputStream);
        Element root = document.getDocumentElement();
        NodeList childNodes = root.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            //判断元素
            if (!(childNodes.item(i) instanceof Element)){
                continue;
            }
            //判断对象
            if (!"bean".equals(childNodes.item(i).getNodeName())){
                continue;
            }
            //解析标签
            Element bean = (Element) childNodes.item(i);
            String id = bean.getAttribute("id");
            String name = bean.getAttribute("name");
            String className = bean.getAttribute("class");
            //获取class
            Class<?> clazz = Class.forName(className);
            //优先级id > name
            String beanName = StrUtil.isNotEmpty(id)?id:name;
            if (StrUtil.isEmpty(beanName)){
                beanName = StrUtil.lowerFirst(clazz.getSimpleName());
            }
            //定义bean
            BeanDefinition beanDefinition = new BeanDefinition(clazz);
            //读取属性填充
            for (int j = 0; j < bean.getChildNodes().getLength(); j++) {
                if (!(bean.getChildNodes().item(j) instanceof Element)){
                    continue;
                }
                if (!"property".equals(bean.getChildNodes().item(j).getNodeName())){
                    continue;
                }

                //解析property标签
                Element property = (Element) bean.getChildNodes().item(j);
                String attrName = property.getAttribute("name");
                String attrValue = property.getAttribute("value");
                String attrRef = property.getAttribute("ref");
                //获取属性值，引入对象，值对象
                Object value = StrUtil.isNotEmpty(attrRef)?new BeanReference(attrRef):attrValue;
                //创建属性信息
                PropertyValue propertyValue = new PropertyValue(attrName,value);
                beanDefinition.getPropertyValues().addPropertyValue(propertyValue);
            }
            if (getRegister().containsBeanDefinition(beanName)){
                throw new BeansException("Duplicate beanName["+beanName+"] is not allowed");
            }
            //注册bean
            getRegister().registerBeanDefinition(beanName,beanDefinition);
        }
    }
}
