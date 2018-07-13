package com.demo.myspring.context.support;

import com.demo.myspring.beans.BeanFactoryAware;
import com.demo.myspring.beans.factory.config.BeanPostProcessor;

/**
 * Created by Marter on 7/13/18.
 */
public class ApplicationContextAwareProcessor implements BeanPostProcessor {

    private AbstractApplicationContext applicationContext;

    public ApplicationContextAwareProcessor(AbstractApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        if (bean instanceof BeanFactoryAware) {
            ((BeanFactoryAware)bean).setBeanFactory(applicationContext.getBeanFactory());
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        return bean;
    }
}
