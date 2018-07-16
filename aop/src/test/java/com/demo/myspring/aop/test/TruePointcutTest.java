package com.demo.myspring.aop.test;

import com.demo.myspring.aop.TruePointcut;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Marter on 7/15/18.
 */
public class TruePointcutTest {

    @Test
    public void testMatch() {
        TruePointcut truePointcut = new TruePointcut();
        Assert.assertTrue(truePointcut.getMethodMatcher().mathes(null, this.getClass()));
    }
}
