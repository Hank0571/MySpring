package com.demo.myspring.aop;

import java.lang.reflect.Method;

/**
 * Interface which check whether method matches or not.
 *
 * Created by Marter on 7/12/18.
 */
public interface MethodMatcher {

    /**
     * Check whether the given method of targetClass matches.
     *
     * @param method
     * @param targetClass
     * @return
     */
    boolean mathes(Method method, Class<?> targetClass);
}
