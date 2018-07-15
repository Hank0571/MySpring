package com.demo.myspring.aop.support;

import com.demo.myspring.aop.AopException;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Marter on 7/14/18.
 */
public class AopUtils {

    public static Object invokeJointpoint(Object target, Method method, Object[] args) {
        try {
            return method.invoke(target, args);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new AopException(e.getMessage());
        }
    }
}
