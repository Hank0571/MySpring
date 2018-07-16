package com.demo.myspring.beans.test;

import com.demo.myspring.beans.PropertyValue;
import com.demo.myspring.beans.factory.config.BeanDefinition;
import com.demo.myspring.beans.factory.support.BeanDefinitionRegistry;
import com.demo.myspring.beans.factory.xml.XmlBeanDefinitionReader;
import com.demo.myspring.beans.test.beans.ListBean;
import com.demo.myspring.core.io.support.ClassPathResource;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;
import java.util.HashMap;

/**
 * Created by Marter on 7/15/18.
 */
public class XmlBeanDefinitionReaderTest {

    @Test
    public void testBeanDefinitionRead() {
        BeanDefinitionRegistry registry = new SimpleBeanDefinitionRegistry();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(registry);
        String path = "xmlBeanDefinitionReaderTest.xml";
        ClassPathResource classPathResource = new ClassPathResource(path);
        reader.loadBeanDefinitions(classPathResource);
        BeanDefinition simpleBeanDefinition = registry.getBeanDefinition("simpleBean");
        Assert.assertNotNull(simpleBeanDefinition);
        BeanDefinition listBeanDefinition = registry.getBeanDefinition("listBean");
        Assert.assertNotNull(listBeanDefinition);
        Assert.assertEquals(ListBean.class.getName(), listBeanDefinition.getBeanClassName());
        PropertyValue propertyValue = listBeanDefinition.getPropertyValues().getPropertyValue("strArray");
        Assert.assertNotNull(propertyValue);
        Assert.assertNotNull(propertyValue.getValue());
    }

    class SimpleBeanDefinitionRegistry implements BeanDefinitionRegistry {

        private Map<String, BeanDefinition> map = new HashMap<>();

        @Override
        public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
            map.put(beanName, beanDefinition);
        }

        @Override
        public BeanDefinition getBeanDefinition(String beanName) {
            return map.get(beanName);
        }
    }
}
