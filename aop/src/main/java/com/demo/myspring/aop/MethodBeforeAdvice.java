package com.demo.myspring.aop;

import org.aopalliance.aop.Advice;

import java.lang.reflect.Method;

/**
 * Advice invoked before method is invoked.
 *
 * Created by Marter on 7/14/18.
 */
public interface MethodBeforeAdvice extends Advice {

    void before(Method method, Object[] args, Object target);
}
