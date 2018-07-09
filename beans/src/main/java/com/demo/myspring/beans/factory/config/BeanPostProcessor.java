package com.demo.myspring.beans.factory.config;

/**
 * Post processor for beans.
 *
 * Created by Marter on 7/7/18.
 */
public interface BeanPostProcessor {

    /**
     * Process before initialization of given bean instance.
     *
     * @param bean
     * @param beanName
     * @return
     */
    Object postProcessBeforeInitialization(Object bean, String beanName);

    /**
     * Process after initialization of given bean instance.
     *
     * @param bean
     * @param beanName
     * @return
     */
    Object postProcessAfterInitialization(Object bean, String beanName);
}
