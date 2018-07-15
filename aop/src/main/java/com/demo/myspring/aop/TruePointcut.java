package com.demo.myspring.aop;

/**
 * Pointcut which always return true.
 *
 * Created by Marter on 7/14/18.
 */
public class TruePointcut implements MethodMatcher, Pointcut {

    public static final TruePointcut INSTANCE = new TruePointcut();

    @Override
    public MethodMatcher getMethodMatcher() {
        return this;
    }

    @Override
    public boolean mathes(java.lang.reflect.Method method, Class<?> targetClass) {
        return true;
    }
}
