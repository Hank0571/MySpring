package com.demo.myspring.example.services;

import com.demo.myspring.beans.BeanFactoryAware;
import com.demo.myspring.beans.factory.BeanFactory;
import com.demo.myspring.beans.factory.FactoryBean;
import com.demo.myspring.example.services.TestRefC;

/**
 * Created by Marter on 7/14/18.
 */
public class TestFactoryBeanD implements FactoryBean<Object>, BeanFactoryAware {

    private BeanFactory beanFactory;
    private String[] names;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    @Override
    public Object getObject() {
        TestRefC testRefC = (TestRefC)beanFactory.getBean("testRefC");
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (String name : names) {
            sb.append(name).append(";");
        }
        sb.append("]");
        testRefC.setText(sb.toString());
        return testRefC;
    }

    public void setNames(String... names) {
        this.names = names;
    }
}
