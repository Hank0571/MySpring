package com.demo.myspring.aop.support;

import com.demo.myspring.aop.MethodMatcher;
import com.demo.myspring.aop.Pointcut;

import java.lang.reflect.Method;

/**
 * Pointcut for simply compare method name.
 *
 * Created by Marter on 7/12/18.
 */
public class NameMatchMethodPointcut implements Pointcut, MethodMatcher {

    private String mappedName;

    public void setMappedName(String mappedName) {
        this.mappedName = mappedName;
    }

    @Override
    public boolean mathes(Method method, Class<?> targetClass) {
        /// Just check method name equality.
        if (mappedName.equals(method.getName())) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public MethodMatcher getMethodMatcher() {
        return this;
    }
}
