package com.demo.myspring.beans.test;

import com.demo.myspring.beans.factory.config.BeanDefinition;
import com.demo.myspring.beans.factory.support.AbstractBeanDefinition;
import com.demo.myspring.beans.factory.support.DefaultListableBeanFactory;
import com.demo.myspring.beans.test.beans.SimpleBean;
import org.junit.Test;
import org.junit.Assert;

import java.util.UUID;

/**
 * Created by Marter on 7/15/18.
 */
public class DefaultListableBeanFactoryTest {


    @Test
    public void testBeanDefinitionRegist() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        AbstractBeanDefinition beanDefinition = new AbstractBeanDefinition();
        String beanName = UUID.randomUUID().toString();
        beanFactory.registerBeanDefinition(beanName, beanDefinition);
        BeanDefinition beanDefinitionResult = beanFactory.getBeanDefinition(beanName);
        Assert.assertEquals(beanDefinition, beanDefinitionResult);
    }

    @Test
    public void testCreateBean() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        AbstractBeanDefinition beanDefinition = new AbstractBeanDefinition();
        beanDefinition.setBeanClass(SimpleBean.class);
        beanDefinition.setBeanClassName(SimpleBean.class.getName());
        beanFactory.registerBeanDefinition("simpleBean", beanDefinition);
        Object bean = beanFactory.getBean("wrongBeanName");
        Assert.assertNull(bean);
        bean = beanFactory.getBean("simpleBean");
        Assert.assertNotNull(bean);
        Assert.assertTrue(bean instanceof SimpleBean);
    }
}
