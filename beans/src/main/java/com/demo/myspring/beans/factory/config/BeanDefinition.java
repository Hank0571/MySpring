package com.demo.myspring.beans.factory.config;

import com.demo.myspring.beans.PropertyValues;

/**
 * Describes a bean instance.
 *
 * Created by Marter on 6/25/18.
 */
public interface BeanDefinition {

    /**
     * Return the bean class.
     *
     * @return
     */
    Class getBeanClass();

    /**
     * Set the bean class.
     *
     * @param beanClass
     */
    void setBeanClass(Class beanClass);

    /**
     * Return the bean class name.
     *
     * @return
     */
    String getBeanClassName();

    /**
     * Set the bean class name.
     *
     * @param beanClassName
     */
    void setBeanClassName(String beanClassName);

    /**
     * Return the property values.
     *
     * @return
     */
    PropertyValues getPropertyValues();

    /**
     * Set the proverty values.
     *
     * @param propertyValues
     */
    void setPropertyValues(PropertyValues propertyValues);
}
