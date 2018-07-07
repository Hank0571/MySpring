package com.demo.myspring.beans.factory.support;

import com.demo.myspring.beans.PropertyValue;
import com.demo.myspring.beans.factory.config.BeanDefinition;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

/**
 * Bean factory which is capable of autowiring.
 *
 * Created by Marter on 6/25/18.
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    @Override
    public Object getBean(String name) throws Exception {
        return null;
    }

    public Object createBean(String name) throws Exception {
        BeanDefinition beanDefinition = getBeanDefinition(name);
        return doCreateBean(beanDefinition);
    }

    /**
     * Create the specified bean from beanDefinition.
     *
     * @param beanDefinition
     * @return
     * @throws Exception
     */
    protected Object doCreateBean(BeanDefinition beanDefinition) throws Exception {
        Object bean = createBeanInstance(beanDefinition);
        populateBean(bean, beanDefinition);
        return bean;
    }

    /**
     * Create a new instance from the specified beanDefinition.
     *
     * @param beanDefinition
     * @return
     * @throws Exception
     */
    protected Object createBeanInstance(BeanDefinition beanDefinition) throws Exception {
        return beanDefinition.getBeanClass().newInstance();
    }

    /**
     * Initialize bean.
     *
     * @param bean
     * @param beanDefinition
     * @throws Exception
     */
    protected void populateBean(Object bean, BeanDefinition beanDefinition) throws Exception {
        applyPropertyValues(bean, beanDefinition);
    }

    /**
     * Apply the given property value.
     *
     * @param bean
     * @param beanDefinition
     * @throws Exception
     */
    protected void applyPropertyValues(Object bean, BeanDefinition beanDefinition) throws Exception {
        BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass());
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();

        PropertyValue[] propertyValues = beanDefinition.getPropertyValues().getPropertyValues();
        for (int i = 0; i < propertyValues.length; i++) {
            PropertyValue propertyValue = propertyValues[i];
            for (int j = 0; j < propertyDescriptors.length; j++) {
                if (propertyDescriptors[j].getName().equals(propertyValue.getName())) {
                    if (propertyValue.getValue() instanceof BeanReference) {
                        BeanReference beanReference = (BeanReference)(propertyValue.getValue());
                        Object refBean = getBean(beanReference.getBeanName());
                        propertyDescriptors[j].getWriteMethod().invoke(bean, refBean);
                    } else {
                        propertyDescriptors[j].getWriteMethod().invoke(bean, propertyValue.getValue());
                    }
                }
            }
        }
    }
}
