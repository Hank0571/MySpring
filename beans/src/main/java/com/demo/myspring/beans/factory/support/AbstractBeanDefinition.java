package com.demo.myspring.beans.factory.support;

import com.demo.myspring.beans.PropertyValues;
import com.demo.myspring.beans.factory.config.BeanDefinition;

/**
 * Concrete bean definition.
 *
 * Created by Marter on 6/25/18.
 */
public class AbstractBeanDefinition implements BeanDefinition {

    private Class beanClass;

    private String beanClassName;

    private PropertyValues propertyValues = new PropertyValues();

    @Override
    public Class getBeanClass() {
        return beanClass;
    }

    @Override
    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    @Override
    public String getBeanClassName() {
        return beanClassName;
    }

    @Override
    public void setBeanClassName(String beanClassName) {
        this.beanClassName = beanClassName;
    }

    @Override
    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    @Override
    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }
}
