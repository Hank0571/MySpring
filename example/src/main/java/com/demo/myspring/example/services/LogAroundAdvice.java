package com.demo.myspring.example.services;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Created by Marter on 7/15/18.
 */
public class LogAroundAdvice implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        long beginTime = System.currentTimeMillis();
        Object result = invocation.proceed();
        long endTime = System.currentTimeMillis();
        String methodName = invocation.getMethod().getName();
        long costTime = endTime - beginTime;
        System.out.println("method of " + methodName + " cost " + costTime + " ms");
        return result;
    }
}
