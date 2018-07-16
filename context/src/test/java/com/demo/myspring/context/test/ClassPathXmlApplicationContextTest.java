package com.demo.myspring.context.test;

import com.demo.myspring.context.support.ClassPathXmlApplicationContext;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Marter on 7/15/18.
 */
public class ClassPathXmlApplicationContextTest {

    @Test
    public void testXmlBean() {
        String[] paths = new String[]{"application-context-test.xml"};
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(paths);
        Object simpleBean = applicationContext.getBean("simpleBean");
        Assert.assertNotNull(simpleBean);
    }
}
