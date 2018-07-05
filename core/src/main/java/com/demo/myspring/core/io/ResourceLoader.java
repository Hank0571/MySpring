package com.demo.myspring.core.io;

/**
 * Interface for Resource loader.
 *
 * Created by Marter on 6/26/18.
 */
public interface ResourceLoader {

    /**
     * Return a Resource handler of the specified location.
     *
     * @param location
     * @return
     */
    Resource getResource(String location);
}
