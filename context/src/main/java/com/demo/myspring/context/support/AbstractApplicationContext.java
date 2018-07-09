package com.demo.myspring.context.support;

import com.demo.myspring.beans.factory.config.BeanPostProcessor;
import com.demo.myspring.beans.factory.support.DefaultListableBeanFactory;
import com.demo.myspring.context.ApplicationContext;

import java.util.Map;

/**
 * Created by Marter on 6/25/18.
 */
public abstract class AbstractApplicationContext implements ApplicationContext {

    protected DefaultListableBeanFactory beanFactory;

    public AbstractApplicationContext() {
        this.beanFactory = getBeanFactory();
    }

    public abstract DefaultListableBeanFactory getBeanFactory();

    protected abstract void refreshBeanFactory();

    /**
     * Refresh context configurations.
     */
    public void refresh() {
        refreshBeanFactory();
        /// Register BeanPostProcessors before other beans.
        registerBeanPostProcessors(beanFactory);
        beanFactory.preInstantiateSingletons();
    }

    /**
     * Register all BeanPostProcessor beans.
     *
     * @param beanFactory
     */
    protected void registerBeanPostProcessors(DefaultListableBeanFactory beanFactory) {
        Map<String, Object> beanMap = beanFactory.getBeansForType(BeanPostProcessor.class);
        for (Map.Entry<String, Object> entry : beanMap.entrySet()) {
            beanFactory.addBeanPostProcessor((BeanPostProcessor)entry.getValue());
        }
    }
}
