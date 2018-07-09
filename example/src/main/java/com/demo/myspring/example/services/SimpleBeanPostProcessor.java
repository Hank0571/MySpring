package com.demo.myspring.example.services;

import com.demo.myspring.beans.factory.config.BeanPostProcessor;

/**
 * Created by Marter on 7/7/18.
 */
public class SimpleBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        System.out.println(beanName + " postProcessBeforeInitialization");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        System.out.println(beanName + " postProcessAfterInitialization");
        return bean;
    }
}
