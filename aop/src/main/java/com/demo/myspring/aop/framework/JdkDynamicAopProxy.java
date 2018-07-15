package com.demo.myspring.aop.framework;

import com.demo.myspring.aop.support.AopUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * AopProxy which based on JDK Proxy.
 *
 * Created by Marter on 7/11/18.
 */
public class JdkDynamicAopProxy implements AopProxy, InvocationHandler {

    private AdvisedSupport advisedSupport;

    public JdkDynamicAopProxy(AdvisedSupport config) {
        this.advisedSupport = config;
    }

    @Override
    public Object getProxy() {
        Object target = advisedSupport.getTarget();
        List<Class> interfaceList = new ArrayList<>();
        for (Class clazz : advisedSupport.getInterfaces()) {
            /// Filer interfaces which is the super class of target class.
            if (clazz.isAssignableFrom(target.getClass())) {
                interfaceList.add(clazz);
            }
        }
        Class[] interfaces = interfaceList.toArray(new Class[interfaceList.size()]);
        return Proxy.newProxyInstance(getClass().getClassLoader(), interfaces, this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object target = advisedSupport.getTarget();
        List<Object> chain = advisedSupport.getInterpretors(method, target.getClass());
        if (chain.isEmpty()) {
            return AopUtils.invokeJointpoint(target, method, args);
        } else {
            ReflectiveMethodInvocation invocation = new ReflectiveMethodInvocation(target, method, args, chain);
            return invocation.proceed();
        }
    }
}
