package com.demo.myspring.aop.framework;

/**
 * Interface of a aop proxy which create proxy objects.
 *
 * Created by Marter on 7/10/18.
 */
public interface AopProxy {

    /**
     * Return a new proxy object.
     *
     * @return
     */
    Object getProxy();
}
