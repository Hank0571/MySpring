package com.demo.myspring.example.sample;

import com.demo.myspring.context.ApplicationContext;
import com.demo.myspring.context.support.ClassPathXmlApplicationContext;
import com.demo.myspring.example.services.TestRefC;

/**
 * Created by Marter on 7/14/18.
 */
public class StepThree {

    public static void main(String[] args) {
        String[] paths = new String[]{"application-three.xml"};
        ApplicationContext ctx = new ClassPathXmlApplicationContext(paths);
        TestRefC testRefC = (TestRefC)ctx.getBean("testFactoryBeanD");
        testRefC.sayHello();
    }
}
