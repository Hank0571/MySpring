package com.demo.myspring.aop.test;

import com.demo.myspring.aop.framework.AdvisedSupport;
import com.demo.myspring.aop.framework.JdkDynamicAopProxy;
import com.demo.myspring.aop.test.beans.SimpleBean;
import com.demo.myspring.aop.test.beans.SimpleInterface;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marter on 7/16/18.
 */
public class JdkDynamicAopProxyTest {

    @Test
    public void testProxy() {
        SimpleBean simpleBean = new SimpleBean();
        AdvisedSupport advisedSupport = new AdvisedSupport();
        advisedSupport.setTarget(simpleBean);
        List<Class> interfaceList = new ArrayList<>();
        interfaceList.add(SimpleInterface.class);
        advisedSupport.setInterfaces(interfaceList);
        JdkDynamicAopProxy jdkProxy = new JdkDynamicAopProxy(advisedSupport);
        Object proxy = jdkProxy.getProxy();
        Assert.assertNotNull(proxy);
        Assert.assertTrue(proxy instanceof SimpleInterface);
    }
}
