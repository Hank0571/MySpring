package com.demo.myspring.beans.factory.support;

import com.demo.myspring.beans.factory.BeanFactory;
import com.demo.myspring.beans.factory.FactoryBean;
import com.demo.myspring.beans.factory.config.BeanDefinition;
import com.demo.myspring.beans.factory.config.BeanPostProcessor;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract class for beanFactory.
 *
 * Created by Marter on 6/25/18.
 */
public abstract class AbstractBeanFactory implements BeanFactory {

    private List<BeanPostProcessor> beanPostProcessors = new ArrayList<>();

    protected abstract BeanDefinition getBeanDefinition(String beanName);
    
    public List<BeanPostProcessor> getBeanPostProcessors() {
        return beanPostProcessors;
    }

    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) {
        beanPostProcessors.remove(beanPostProcessor);
        beanPostProcessors.add(beanPostProcessor);
    }

    protected Object getObjectForBeanInstance(Object beanInstance, String beanName) {
        if (beanInstance == null) {
            return null;
        }
        if (beanInstance instanceof FactoryBean) {
            return ((FactoryBean)beanInstance).getObject();
        } else {
            return beanInstance;
        }
    }
}
