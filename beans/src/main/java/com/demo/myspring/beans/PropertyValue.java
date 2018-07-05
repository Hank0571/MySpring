package com.demo.myspring.beans;

/**
 * Describes a bean property.
 *
 * Created by Marter on 6/25/18.
 */
public class PropertyValue {

    private Object value;

    private String name;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
