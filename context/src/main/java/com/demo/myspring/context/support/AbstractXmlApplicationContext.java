package com.demo.myspring.context.support;

import com.demo.myspring.beans.factory.support.DefaultListableBeanFactory;
import com.demo.myspring.beans.factory.xml.XmlBeanDefinitionReader;
import com.demo.myspring.core.io.Resource;

/**
 * Abstract xml applicaiton context which could load xml config files.
 *
 * Created by Marter on 6/26/18.
 */
public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext {

    public AbstractXmlApplicationContext() {

    }

    public void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        beanDefinitionReader.loadBeanDefinitions(getConfigResources());
    }

    @Override
    public Object getBean(String name) {
        return getBeanFactory().getBean(name);
    }

    /**
     * Return config resource array.
     *
     * @return
     */
    protected Resource[] getConfigResources() {
        return null;
    }
}
