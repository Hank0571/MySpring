package com.demo.myspring.aop.test;

import com.demo.myspring.aop.support.AopUtils;
import com.demo.myspring.aop.test.beans.SimpleBean;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Method;
import java.util.UUID;

/**
 * Created by Marter on 7/15/18.
 */
public class AopUtilsTest {

    @Test
    public void testInvoke() throws Exception {
        SimpleBean simpleBean = new SimpleBean();
        String value = UUID.randomUUID().toString();
        simpleBean.setText(value);

        Class[] argTypes = new Class[]{};
        Method method = SimpleBean.class.getMethod("getText", argTypes);
        Object[] args = new Object[]{};
        Object result = AopUtils.invokeJointpoint(simpleBean, method, args);
        Assert.assertTrue(result instanceof String);
        Assert.assertEquals(value, result);
    }
}
