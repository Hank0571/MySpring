package com.demo.myspring.beans.factory;

/**
 * Spring bean factory. Basic client of a bean container.
 *
 * Created by Marter on 6/25/18.
 */
public interface BeanFactory {

    Object getBean(String name) throws Exception;
}
