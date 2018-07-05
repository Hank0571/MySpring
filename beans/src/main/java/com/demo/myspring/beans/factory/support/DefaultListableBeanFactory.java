package com.demo.myspring.beans.factory.support;

import com.demo.myspring.beans.factory.config.BeanDefinition;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Marter on 6/26/18.
 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry {

    /** Map of beanDefinition, keyed by bean name */
    private final Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>(16);
    /** Map of singleton objects */
    private final Map<String, Object> singleObjects = new ConcurrentHashMap<>(16);

    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        synchronized (this.beanDefinitionMap) {
            BeanDefinition oldBeanDefinition = beanDefinitionMap.get(beanName);
            if (oldBeanDefinition == null) {
                beanDefinitionMap.put(beanName, beanDefinition);
            }
        }
    }

    @Override
    public BeanDefinition getBeanDefinition(String beanName) {
        return beanDefinitionMap.get(beanName);
    }

    @Override
    public Object getBean(String name) throws Exception {
        Object bean = singleObjects.get(name);
        if (bean == null) {
            BeanDefinition beanDefinition = beanDefinitionMap.get(name);
            if (beanDefinition != null) {
                bean = doCreateBean(beanDefinition);
                singleObjects.put(name, bean);
                return bean;
            }
        }
        return null;
    }
}
