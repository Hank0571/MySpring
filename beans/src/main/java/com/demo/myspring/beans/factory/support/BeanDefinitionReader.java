package com.demo.myspring.beans.factory.support;

import com.demo.myspring.core.io.Resource;

/**
 * Bean definition reader which load resource of definitions.
 *
 * Created by Marter on 6/25/18.
 */
public interface BeanDefinitionReader {

    /**
     * Load bean definition from the specified resource.
     *
     * @param resource
     * @return
     */
    int loadBeanDefinitions(Resource resource);

    /**
     * Load bean definition from the specified resource array.
     *
     * @param resources
     * @return
     */
    int loadBeanDefinitions(Resource[] resources);
}
