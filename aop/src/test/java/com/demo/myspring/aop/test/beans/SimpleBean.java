package com.demo.myspring.aop.test.beans;

/**
 * Created by Marter on 7/15/18.
 */
public class SimpleBean implements SimpleInterface {

    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void print() {
        System.out.println("text = " + text);
    }
}
