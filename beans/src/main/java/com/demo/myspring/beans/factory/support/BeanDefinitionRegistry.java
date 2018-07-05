package com.demo.myspring.beans.factory.support;

import com.demo.myspring.beans.factory.config.BeanDefinition;

/**
 * Registry which holds bean definition.
 *
 * Created by Marter on 6/25/18.
 */
public interface BeanDefinitionRegistry {

    /**
     * Register a new BeanDefinition
     *
     * @param beanName
     * @param beanDefinition
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

    /**
     * Return the BeanDefinition for the given bean name.
     *
     * @param beanName
     * @return
     */
    BeanDefinition getBeanDefinition(String beanName);
}
