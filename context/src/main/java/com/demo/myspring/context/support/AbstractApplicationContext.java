package com.demo.myspring.context.support;

import com.demo.myspring.beans.factory.BeanFactory;
import com.demo.myspring.beans.factory.support.AbstractAutowireCapableBeanFactory;
import com.demo.myspring.context.ApplicationContext;

/**
 * Created by Marter on 6/25/18.
 */
public abstract class AbstractApplicationContext implements ApplicationContext {

    protected BeanFactory beanFactory;

    public AbstractApplicationContext() {
        this.beanFactory = getBeanFactory();
    }

    public abstract AbstractAutowireCapableBeanFactory getBeanFactory();

    protected abstract void refreshBeanFactory();

    /**
     * Refresh context configurations.
     */
    public void refresh() {
       refreshBeanFactory();
    }
}
