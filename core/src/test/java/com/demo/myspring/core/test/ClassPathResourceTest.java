package com.demo.myspring.core.test;

import org.junit.Assert;
import org.junit.Test;

import com.demo.myspring.core.io.support.ClassPathResource;

/**
 * Created by Marter on 7/15/18.
 */
public class ClassPathResourceTest {

    @Test
    public void testInputStream() {
        String path = "application-core-test.xml";
        ClassPathResource classPathResource = new ClassPathResource(path);
        Assert.assertNotNull(classPathResource.getInputStream());
    }
}
