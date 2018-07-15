package com.demo.myspring.aop.framework;

import com.demo.myspring.aop.Advisor;
import com.demo.myspring.aop.AopException;
import com.demo.myspring.aop.support.DefaultPointcutAdvisor;
import com.demo.myspring.beans.BeanFactoryAware;
import com.demo.myspring.beans.factory.BeanFactory;
import com.demo.myspring.beans.factory.FactoryBean;
import org.aopalliance.aop.Advice;

import java.util.ArrayList;
import java.util.List;

/**
 * Aop proxy based on beans in Spring.
 *
 * Created by Marter on 7/11/18.
 */
public class ProxyFactoryBean extends ProxyCreatorSupport implements FactoryBean<Object>, BeanFactoryAware {

    private String[] interceptorNames;

    private Object singletonInstance;

    private BeanFactory beanFactory;

    private boolean advisorChainInitialized = false;

    public void setProxyInterfaces(String... proxyInterfaces) {
        List<Class> interfaces = new ArrayList<>();
        for (String proxyInterface : proxyInterfaces) {
            try {
                Class<?> clazz = Class.forName(proxyInterface);
                if (!interfaces.contains(clazz)) {
                    interfaces.add(clazz);
                }
            } catch (ClassNotFoundException e) {

            }
        }
        setInterfaces(interfaces);
    }

    public void setInterceptorNames(String... interceptorNames) {
        this.interceptorNames = interceptorNames;
    }

    @Override
    public Object getObject() {
        if (!advisorChainInitialized) {
            initializeAdvisorChain();
            advisorChainInitialized = true;
        }
        return getSingletonInstance();
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    private void initializeAdvisorChain() {
        for (String name : this.interceptorNames) {
            Object bean = beanFactory.getBean(name);
            addAdvisor(namedBeanToAdvisor(bean));
        }
    }

    private Object getSingletonInstance() {
        if (singletonInstance == null) {
            singletonInstance = createAopProxy().getProxy();
        }
        return singletonInstance;
    }

    private Advisor namedBeanToAdvisor(Object bean) {
        if (bean instanceof Advisor) {
            return (Advisor)bean;
        } else if (bean instanceof Advice) {
            return new DefaultPointcutAdvisor((Advice)bean);
        }
        throw new AopException("error bean type");
    }
}
