package com.demo.myspring.aop;

import org.aopalliance.aop.Advice;

/**
 * Interface holding Advice.
 *
 * Created by Marter on 7/10/18.
 */
public interface Advisor {

    Advice getAdvice();
}
