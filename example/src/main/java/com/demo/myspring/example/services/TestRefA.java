package com.demo.myspring.example.services;

/**
 * Created by Marter on 7/5/18.
 */
public class TestRefA {

    private String text;
    private TestRefB testRefB;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public TestRefB getTestRefB() {
        return testRefB;
    }

    public void setTestRefB(TestRefB testRefB) {
        this.testRefB = testRefB;
    }

    public void sayHello() {
        System.out.println("Hello " + text + " -> " + testRefB.getText() + ".");
    }
}
