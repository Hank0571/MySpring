package com.demo.myspring.aop;

/**
 * Combination of pointcut and advice.
 *
 * Created by Marter on 7/12/18.
 */
public interface PointcutAdvisor extends Advisor {

    Pointcut getPointcut();
}
