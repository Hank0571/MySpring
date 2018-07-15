package com.demo.myspring.aop.framework;

import com.demo.myspring.aop.support.AopUtils;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;
import java.util.List;

/**
 * Implementation of AopAlliance's MethodInvocation interface.
 *
 * Created by Marter on 7/14/18.
 */
public class ReflectiveMethodInvocation implements MethodInvocation {

    private Method method;
    private Object[] arguments;
    private Object target;
    private List<Object> interceptors;
    private int currentInterceptorIndex = 0;

    public ReflectiveMethodInvocation(Object target, Method method, Object[] arguments, List<Object> interceptors) {
        this.target = target;
        this.method = method;
        this.arguments = arguments;
        this.interceptors = interceptors;
    }

    @Override
    public Method getMethod() {
        return this.method;
    }

    @Override
    public Object[] getArguments() {
        return this.arguments;
    }

    @Override
    public Object proceed() throws Throwable {
        if (currentInterceptorIndex == interceptors.size()) {
            return AopUtils.invokeJointpoint(target, method, arguments);
        } else {
            MethodInterceptor methodInterceptor = (MethodInterceptor)interceptors.get(currentInterceptorIndex);
            currentInterceptorIndex++;
            return methodInterceptor.invoke(this);
        }
    }

    @Override
    public Object getThis() {
        return this.target;
    }

    @Override
    public AccessibleObject getStaticPart() {
        return this.method;
    }
}
