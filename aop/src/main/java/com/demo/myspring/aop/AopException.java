package com.demo.myspring.aop;

/**
 * Created by Marter on 7/13/18.
 */
public class AopException extends RuntimeException {

    private String msg;

    public AopException(String msg) {
        this.msg = msg;
    }
}
