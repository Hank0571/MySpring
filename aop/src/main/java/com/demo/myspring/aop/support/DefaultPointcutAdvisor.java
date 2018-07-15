package com.demo.myspring.aop.support;

import com.demo.myspring.aop.Pointcut;
import com.demo.myspring.aop.PointcutAdvisor;
import com.demo.myspring.aop.TruePointcut;
import org.aopalliance.aop.Advice;

/**
 * Default implementation of PointcutAdvisor.
 *
 * Created by Marter on 7/12/18.
 */
public class DefaultPointcutAdvisor implements PointcutAdvisor {

    private Pointcut pointcut;
    private Advice advice;

    public DefaultPointcutAdvisor() {
        this(TruePointcut.INSTANCE, null);
    }

    public DefaultPointcutAdvisor(Advice advice) {
        this(TruePointcut.INSTANCE, advice);
    }

    public DefaultPointcutAdvisor(Pointcut pointcut, Advice advice) {
        this.pointcut = pointcut;
        this.advice = advice;
    }

    @Override
    public Advice getAdvice() {
        return advice;
    }

    public void setAdvice(Advice advice) {
        this.advice = advice;
    }

    @Override
    public Pointcut getPointcut() {
        return pointcut;
    }

    public void setPointcut(Pointcut pointcut) {
        this.pointcut = pointcut;
    }
}
