package com.demo.myspring.context.support;

import com.demo.myspring.core.io.Resource;
import com.demo.myspring.core.io.support.ClassPathResource;

/**
 * Xml application context which load configuration files from class path.
 *
 * Created by Marter on 6/25/18.
 */
public class ClassPathXmlApplicationContext extends AbstractXmlApplicationContext {

    private Resource[] configResources;

    public ClassPathXmlApplicationContext(String[] paths) {
        this.configResources = new Resource[paths.length];
        for (int i = 0; i < paths.length; i++) {
            this.configResources[i] = new ClassPathResource(paths[i]);
        }
        refresh();
    }

    @Override
    protected Resource[] getConfigResources() {
        return this.configResources;
    }
}
