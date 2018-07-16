package com.demo.myspring.beans.test.beans;

import com.demo.myspring.beans.BeanException;
import com.demo.myspring.beans.factory.FactoryBean;

/**
 * Created by Marter on 7/15/18.
 */
public class SimpleFactoryBean implements FactoryBean<Object> {

    private Object object = new SimpleBean();

    public Object getObject() throws BeanException {
        return object;
    }
}
