package com.demo.myspring.beans.factory.support;

import com.demo.myspring.beans.BeanException;
import com.demo.myspring.beans.PropertyValue;
import com.demo.myspring.beans.factory.config.BeanDefinition;
import com.demo.myspring.beans.factory.config.BeanPostProcessor;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.List;

/**
 * Bean factory which is capable of autowiring.
 *
 * Created by Marter on 6/25/18.
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    @Override
    public Object getBean(String name) throws BeanException {
        return null;
    }

    public Object createBean(String name) throws BeanException {
        BeanDefinition beanDefinition = getBeanDefinition(name);
        return doCreateBean(name, beanDefinition);
    }

    /**
     * Create the specified bean from beanDefinition.
     *
     * @param beanDefinition
     * @return
     * @throws Exception
     */
    protected Object doCreateBean(String beanName, BeanDefinition beanDefinition) throws BeanException {
        Object bean = createBeanInstance(beanDefinition);
        populateBean(bean, beanDefinition);
        initializeBean(beanName, bean);
        return bean;
    }

    /**
     * Create a new instance from the specified beanDefinition.
     *
     * @param beanDefinition
     * @return
     * @throws Exception
     */
    protected Object createBeanInstance(BeanDefinition beanDefinition) throws BeanException {
        try {
            return beanDefinition.getBeanClass().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new BeanException("create " + beanDefinition.getBeanClassName() + " instance error");
        }
    }

    /**
     * Initialize bean.
     *
     * @param bean
     * @param beanDefinition
     * @throws Exception
     */
    protected void populateBean(Object bean, BeanDefinition beanDefinition) throws BeanException {
        applyPropertyValues(bean, beanDefinition);
    }

    /**
     * Apply the given property value.
     *
     * @param bean
     * @param beanDefinition
     * @throws Exception
     */
    protected void applyPropertyValues(Object bean, BeanDefinition beanDefinition) throws BeanException {
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();

            PropertyValue[] propertyValues = beanDefinition.getPropertyValues().getPropertyValues();
            for (int i = 0; i < propertyValues.length; i++) {
                PropertyValue propertyValue = propertyValues[i];
                for (int j = 0; j < propertyDescriptors.length; j++) {
                    if (propertyDescriptors[j].getName().equals(propertyValue.getName())) {
                        if (propertyValue.getValue() instanceof BeanReference) {
                            BeanReference beanReference = (BeanReference) (propertyValue.getValue());
                            Object refBean = getBean(beanReference.getBeanName());
                            propertyDescriptors[j].getWriteMethod().invoke(bean, refBean);
                        } else {
                            propertyDescriptors[j].getWriteMethod().invoke(bean, propertyValue.getValue());
                        }
                    }
                }
            }
        } catch (Exception e) {
            throw new BeanException(e.getMessage());
        }
    }

    protected Object initializeBean(String beanName, Object bean) {
        applyBeanPostProcessorsBeforeInitialization(beanName, bean);
        applyBeanPostProcessorsAfterInitialization(beanName, bean);
        return bean;
    }

    protected Object applyBeanPostProcessorsBeforeInitialization(String beanName, Object bean) {
        List<BeanPostProcessor> beanPostProcessorList = getBeanPostProcessors();
        if (beanPostProcessorList == null) {
            return null;
        }
        for (BeanPostProcessor beanPostProcessor : beanPostProcessorList) {
            beanPostProcessor.postProcessBeforeInitialization(bean, beanName);
        }
        return null;
    }

    protected Object applyBeanPostProcessorsAfterInitialization(String beanName, Object bean) {
        List<BeanPostProcessor> beanPostProcessorList = getBeanPostProcessors();
        if (beanPostProcessorList == null) {
            return null;
        }
        for (BeanPostProcessor beanPostProcessor : beanPostProcessorList) {
            beanPostProcessor.postProcessAfterInitialization(bean, beanName);
        }
        return null;
    }
}
