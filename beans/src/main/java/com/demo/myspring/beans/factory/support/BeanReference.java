package com.demo.myspring.beans.factory.support;

/**
 * Reference to a bean.
 *
 * Created by Marter on 7/5/18.
 */
public class BeanReference {

    private String beanName;

    private Object bean;

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    public Object getBean() {
        return bean;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }
}
