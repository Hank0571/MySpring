package com.demo.myspring.beans.factory;

import com.demo.myspring.beans.BeanException;

/**
 * Bean which is used as a factory.
 *
 * Created by Marter on 7/10/18.
 */
public interface FactoryBean<T> {

    /**
     * Return an instance of bean.
     *
     * @return
     * @throws BeanException
     */
    T getObject() throws BeanException;
}
