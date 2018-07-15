package com.demo.myspring.aop;

/**
 * Pointcut.
 *
 * Created by Marter on 7/12/18.
 */
public interface Pointcut {

    /**
     * Return MethodMatcher of Pointcut.
     *
     * @return
     */
    MethodMatcher getMethodMatcher();
}
