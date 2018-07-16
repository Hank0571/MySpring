package com.demo.myspring.beans.test;

import com.demo.myspring.beans.PropertyValue;
import com.demo.myspring.beans.PropertyValues;
import org.junit.Assert;
import org.junit.Test;

import java.util.UUID;

/**
 * Created by Marter on 7/15/18.
 */
public class PropertyValuesTest {

    private PropertyValues propertyValues = new PropertyValues();

    @Test
    public void testAddAndGetter() {
        String name = UUID.randomUUID().toString();
        String value = "value";
        PropertyValue propertyValue = new PropertyValue(name, value);
        propertyValues.addPropertyValue(propertyValue);

        Assert.assertNotNull(propertyValues.getPropertyValue(name));
        int currentSize = propertyValues.getPropertyValues().length;
        Assert.assertEquals(currentSize, 1);
    }
}
