myspring
=======

尝试完成一个微型的Spring，参考了 [tiny-spring](https://github.com/code4craft/tiny-spring) 和 [Spring 3.2.x](https://github.com/spring-projects/spring-framework/tree/3.2.x)。

## 1. step one

    git checkout step-one

实现了IoC最基本的功能，支持从xml配置文件读取单例，支持属性注入（不支持引用）。测试代码见com.demo.myspring.example.sample.StepOne。

## 2. step two

    git checkout step-two

增加属性注入功能（仅单例），支持循环引用，支持后置处理器。测试代码见com.demo.myspring.example.sample.StepTwo。

## 3. step three

    git checkout step-three

增加bean工厂类，增加BeanFactoryAware接口，支持属性为字符串数组。测试代码见com.demo.myspring.example.sample.StepThree。

## 4. step four

    git checkout step-four

实现AOP中的两个基本配置：*Advice*（前置增强）和*Pointcut*（方法名匹配）；实现基于JDK动态代理的AopProxy；实现基于配置的*ProxyFactoryBean*。
