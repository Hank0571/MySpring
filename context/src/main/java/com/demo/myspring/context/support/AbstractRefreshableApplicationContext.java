package com.demo.myspring.context.support;

import com.demo.myspring.beans.factory.support.AbstractAutowireCapableBeanFactory;
import com.demo.myspring.beans.factory.support.DefaultListableBeanFactory;

/**
 * Application context which is capable of refresh bean factory.
 *
 * Created by Marter on 7/2/18.
 */
public abstract class AbstractRefreshableApplicationContext extends AbstractApplicationContext {

    private String[] configLocations;

    private DefaultListableBeanFactory beanFactory;

    public abstract void loadBeanDefinitions(DefaultListableBeanFactory beanFactory);

    protected DefaultListableBeanFactory createBeanFactory() {
        return new DefaultListableBeanFactory();
    }

    @Override
    public AbstractAutowireCapableBeanFactory getBeanFactory() {
        return beanFactory;
    }

    @Override
    protected void refreshBeanFactory() {
        DefaultListableBeanFactory beanFactory = createBeanFactory();
        loadBeanDefinitions(beanFactory);
        this.beanFactory = beanFactory;
    }
}
