package com.demo.myspring.example.sample;

import com.demo.myspring.context.ApplicationContext;
import com.demo.myspring.context.support.ClassPathXmlApplicationContext;
import com.demo.myspring.example.services.SimpleTest;

/**
 * Created by Marter on 7/15/18.
 */
public class StepFour {

    public static void main(String[] args) {
        String[] paths = new String[]{"application-four.xml"};
        ApplicationContext ctx = new ClassPathXmlApplicationContext(paths);
        SimpleTest simpleTest = (SimpleTest)ctx.getBean("factoryBean");
        simpleTest.sayHello();
    }
}
