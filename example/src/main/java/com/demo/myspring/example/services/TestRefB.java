package com.demo.myspring.example.services;

/**
 * Created by Marter on 7/5/18.
 */
public class TestRefB {

    private String text;
    private TestRefA testRefA;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public TestRefA getTestRefA() {
        return testRefA;
    }

    public void setTestRefA(TestRefA testRefA) {
        this.testRefA = testRefA;
    }

    public void sayHello() {
        System.out.println("Hello " + text + " -> " + testRefA.getText() + ".");
    }
}
