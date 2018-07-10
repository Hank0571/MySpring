package com.demo.myspring.beans.factory.support;

import com.demo.myspring.beans.BeanException;
import com.demo.myspring.beans.factory.config.BeanDefinition;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Marter on 6/26/18.
 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry {

    /** Map of beanDefinition, keyed by bean name **/
    private final Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>(16);
    /** Map of singleton objects **/
    private final Map<String, Object> singleObjects = new ConcurrentHashMap<>(16);
    /** Map of early created singleton objects **/
    private final Map<String, Object> earlySingleObjects = new ConcurrentHashMap<>(16);

    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        synchronized (this.beanDefinitionMap) {
            BeanDefinition oldBeanDefinition = beanDefinitionMap.get(beanName);
            if (oldBeanDefinition == null) {
                beanDefinitionMap.put(beanName, beanDefinition);
            }
        }
    }

    @Override
    public BeanDefinition getBeanDefinition(String beanName) {
        return beanDefinitionMap.get(beanName);
    }

    @Override
    public Object createBean(String name) throws BeanException {
        Object bean = singleObjects.get(name);
        if (bean == null) {
            BeanDefinition beanDefinition = beanDefinitionMap.get(name);
            bean = earlySingleObjects.get(name);
            if (bean == null) {
                if (beanDefinition != null) {
                    bean = createBeanInstance(beanDefinition);
                    earlySingleObjects.put(name, bean);
                }
            }
            if (beanDefinition != null) {
                populateBean(bean, beanDefinition);
                initializeBean(name, bean);
                earlySingleObjects.remove(name);
                singleObjects.put(name, bean);
            }
        }
        return getObjectForBeanInstance(bean, name);
    }

    @Override
    public Object getBean(String name) throws BeanException {
        Object bean = singleObjects.get(name);
        if (bean == null) {
            /// Check if bean is creating.
            bean = earlySingleObjects.get(name);
            if (bean == null) {
                return createBean(name);
            }
        }
        return getObjectForBeanInstance(bean, name);
    }

    public Map<String, Object> getBeansForType(Class<?> type) {
        Map<String, Object> beanMap = new HashMap<>();
        for (Map.Entry<String, BeanDefinition> entry : beanDefinitionMap.entrySet()) {
            if (type.isAssignableFrom(entry.getValue().getBeanClass())) {
                Object bean = getBean(entry.getKey());
                beanMap.put(entry.getKey(), bean);
            }
        }
        return beanMap;
    }

    /**
     * Instantiate all singleton beans.
     */
    public void preInstantiateSingletons() {
        for (String key : this.beanDefinitionMap.keySet()) {
            getBean(key);
        }
    }
}
