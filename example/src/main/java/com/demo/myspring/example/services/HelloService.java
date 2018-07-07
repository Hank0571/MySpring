package com.demo.myspring.example.services;

/**
 * Created by Marter on 7/2/18.
 */
public class HelloService {

    private String text;

    public void setText(String text) {
        this.text = text;
    }

    public void sayHello() {
        System.out.println("Hello " + text + ".");

    }
}
