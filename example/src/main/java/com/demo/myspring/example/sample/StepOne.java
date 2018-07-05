package com.demo.myspring.example.sample;

import com.demo.myspring.context.ApplicationContext;
import com.demo.myspring.context.support.ClassPathXmlApplicationContext;
import com.demo.myspring.example.services.HelloService;

/**
 * Created by Marter on 7/2/18.
 */
public class StepOne {

    public static void main(String[] args) throws Exception {
        String[] paths = new String[1];
        paths[0] = "application.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(paths);
        HelloService helloService = (HelloService)ctx.getBean("helloService");
        helloService.sayHello();
    }
}
