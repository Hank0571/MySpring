package com.demo.myspring.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marter on 6/25/18.
 */
public class PropertyValues {

    private List<PropertyValue> propertyValueList = new ArrayList<>();

    /**
     * Return an array of all the property values.
     *
     * @return
     */
    public PropertyValue[] getPropertyValues() {
        return propertyValueList.toArray(new PropertyValue[propertyValueList.size()]);
    }

    /**
     * Return the propertyValue of a given property name.
     *
     * @param propertyName
     * @return
     */
    public PropertyValue getPropertyValue(String propertyName) {
        for (PropertyValue propertyValue : propertyValueList) {
            if (propertyValue.getName().equals(propertyName)) {
                return propertyValue;
            }
        }
        return null;
    }

    public PropertyValues addPropertyValue(PropertyValue pv) {
        for (int i = 0; i < this.propertyValueList.size(); i++) {
            PropertyValue currentPv = this.propertyValueList.get(i);
            if (currentPv.getName().equals(pv.getName())) {
                return this;
            }
        }
        propertyValueList.add(pv);
        return this;
    }
}
