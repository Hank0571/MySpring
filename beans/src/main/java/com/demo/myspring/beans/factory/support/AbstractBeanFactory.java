package com.demo.myspring.beans.factory.support;

import com.demo.myspring.beans.factory.BeanFactory;
import com.demo.myspring.beans.factory.config.BeanDefinition;

/**
 * Abstract class for beanFactory.
 *
 * Created by Marter on 6/25/18.
 */
public abstract class AbstractBeanFactory implements BeanFactory {

    protected abstract BeanDefinition getBeanDefinition(String beanName);
}
