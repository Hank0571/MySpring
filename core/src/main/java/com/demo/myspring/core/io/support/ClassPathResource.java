package com.demo.myspring.core.io.support;

import java.io.InputStream;

/**
 * Implementation of class path Resource.
 *
 * Created by Marter on 7/2/18.
 */
public class ClassPathResource extends AbstractResource {

    private final String path;
    private Class<?> clazz;

    public ClassPathResource(String path) {
        this.path = path;
        this.clazz = this.getClass();
    }

    @Override
    public InputStream getInputStream() {
        return this.clazz.getClassLoader().getResourceAsStream(this.path);
    }
}
