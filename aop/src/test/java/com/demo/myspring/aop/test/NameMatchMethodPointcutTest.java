package com.demo.myspring.aop.test;

import com.demo.myspring.aop.support.NameMatchMethodPointcut;
import com.demo.myspring.aop.test.beans.SimpleBean;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * Created by Marter on 7/15/18.
 */
public class NameMatchMethodPointcutTest {

    @Test
    public void testMatch() throws Exception {
        NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
        pointcut.setMappedName("getText");
        Class[] getArgTypes = new Class[]{};
        Method getter = SimpleBean.class.getMethod("getText", getArgTypes);
        Class[] setArgTypes = new Class[]{String.class};
        Method setter = SimpleBean.class.getMethod("setText", setArgTypes);
        Assert.assertTrue(pointcut.mathes(getter, SimpleBean.class));
        Assert.assertFalse(pointcut.mathes(setter, SimpleBean.class));
    }
}
