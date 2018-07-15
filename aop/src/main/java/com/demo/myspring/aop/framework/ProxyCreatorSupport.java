package com.demo.myspring.aop.framework;

/**
 * ApoProxy factory.
 *
 * Created by Marter on 7/11/18.
 */
public class ProxyCreatorSupport extends AdvisedSupport {

    public AopProxy createAopProxy() {
        /// TODO: Cglib Proxy

        return new JdkDynamicAopProxy(this);
    }
}
