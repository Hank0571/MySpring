package com.demo.myspring.beans.factory.support;

import com.demo.myspring.core.io.ResourceLoader;

/**
 * Abstract class for beanDefinitionReader.
 *
 * Created by Marter on 6/26/18.
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {

    private BeanDefinitionRegistry registry;

    private ResourceLoader resourceLoader;

    protected AbstractBeanDefinitionReader(BeanDefinitionRegistry registry) {
        this.registry = registry;
    }

    public BeanDefinitionRegistry getRegistry() {
        return this.registry;
    }

    public ResourceLoader getResourceLoader() {
        return this.resourceLoader;
    }
}
