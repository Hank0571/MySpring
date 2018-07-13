package com.demo.myspring.beans;

import com.demo.myspring.beans.factory.BeanFactory;

/**
 * Created by Marter on 7/13/18.
 */
public interface BeanFactoryAware extends Aware {

    void setBeanFactory(BeanFactory beanFactory);
}
