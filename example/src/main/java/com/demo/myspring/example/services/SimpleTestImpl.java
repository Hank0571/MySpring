package com.demo.myspring.example.services;

/**
 * Created by Marter on 7/15/18.
 */
public class SimpleTestImpl implements SimpleTest {

    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void sayHello() {
        System.out.println("TestBean said " + text);
    }
}
