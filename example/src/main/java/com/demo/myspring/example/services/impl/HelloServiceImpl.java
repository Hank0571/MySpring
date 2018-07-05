package com.demo.myspring.example.services.impl;

import com.demo.myspring.example.services.HelloService;

/**
 * Created by Marter on 7/2/18.
 */
public class HelloServiceImpl implements HelloService {

    private String text;

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public void sayHello() {
        System.out.println("Hello " + text + ".");
    }
}
