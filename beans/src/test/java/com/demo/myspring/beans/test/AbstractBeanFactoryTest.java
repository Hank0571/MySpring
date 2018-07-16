package com.demo.myspring.beans.test;

import com.demo.myspring.beans.BeanException;
import com.demo.myspring.beans.factory.config.BeanDefinition;
import com.demo.myspring.beans.factory.support.AbstractBeanFactory;
import com.demo.myspring.beans.test.beans.SimpleBean;
import com.demo.myspring.beans.test.beans.SimpleFactoryBean;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Marter on 7/15/18.
 */
public class AbstractBeanFactoryTest {

    class BaseBeanFactory extends AbstractBeanFactory {
        @Override
        protected BeanDefinition getBeanDefinition(String beanName) {
            return null;
        }

        @Override
        public Object getBean(String name) throws BeanException {
            return null;
        }

        public Object getObjectForBeanInstance(Object beanInstance, String beanName) {
            return super.getObjectForBeanInstance(beanInstance, beanName);

        }
    }

    private BaseBeanFactory baseBeanFactory = new BaseBeanFactory();


    @Test
    public void testFactoryBean() {
        SimpleBean simpleBean = new SimpleBean();
        Object bean = baseBeanFactory.getObjectForBeanInstance(simpleBean, "simpleBean");
        Assert.assertTrue(bean instanceof SimpleBean);

        SimpleFactoryBean simpleFactoryBean = new SimpleFactoryBean();
        bean = baseBeanFactory.getObjectForBeanInstance(simpleFactoryBean, "simpleFactoryBean");
        Assert.assertTrue(bean instanceof SimpleBean);
    }
}
