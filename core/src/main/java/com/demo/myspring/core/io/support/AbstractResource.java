package com.demo.myspring.core.io.support;

import com.demo.myspring.core.io.Resource;

import java.io.InputStream;

/**
 * Abstract class for Resource.
 *
 * Created by Marter on 7/2/18.
 */
public abstract class AbstractResource implements Resource {

    @Override
    public abstract InputStream getInputStream();
}
