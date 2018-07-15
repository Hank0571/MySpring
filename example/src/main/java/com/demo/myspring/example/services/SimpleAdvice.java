package com.demo.myspring.example.services;

import com.demo.myspring.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by Marter on 7/15/18.
 */
public class SimpleAdvice implements MethodBeforeAdvice{

    @Override
    public void before(Method method, Object[] args, Object target) {
        System.out.println("Begin to process " + method.getName());
    }
}
