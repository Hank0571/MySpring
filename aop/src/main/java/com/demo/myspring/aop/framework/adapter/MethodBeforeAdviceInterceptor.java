package com.demo.myspring.aop.framework.adapter;

import com.demo.myspring.aop.MethodBeforeAdvice;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * MethodInterceptor which invoked before a method is invoked.
 *
 * Created by Marter on 7/14/18.
 */
public class MethodBeforeAdviceInterceptor implements MethodInterceptor {

    private MethodBeforeAdvice methodBeforeAdvice;

    public MethodBeforeAdviceInterceptor(MethodBeforeAdvice advice) {
        this.methodBeforeAdvice = advice;
    }

    public Object invoke(MethodInvocation invocation) throws Throwable {
        this.methodBeforeAdvice.before(invocation.getMethod(), invocation.getArguments(), invocation.getThis());
        return invocation.proceed();
    }
}
