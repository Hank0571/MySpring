package com.demo.myspring.example.sample;

import com.demo.myspring.context.ApplicationContext;
import com.demo.myspring.context.support.ClassPathXmlApplicationContext;
import com.demo.myspring.example.services.TestRefA;
import com.demo.myspring.example.services.TestRefB;
import com.demo.myspring.example.services.TestRefC;

/**
 * Created by Marter on 7/5/18.
 */
public class StepTwo {

    public static void main(String[] args) throws Exception {
        String[] paths = new String[1];
        paths[0] = "application-two.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(paths);
        TestRefA testRefA = (TestRefA)ctx.getBean("testRefA");
        testRefA.sayHello();
        TestRefB testRefB = (TestRefB)ctx.getBean("testRefB");
        testRefB.sayHello();
        TestRefC testRefC = (TestRefC)ctx.getBean("testRefC");
        testRefC.sayHello();
    }
}
