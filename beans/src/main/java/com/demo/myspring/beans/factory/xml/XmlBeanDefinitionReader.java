package com.demo.myspring.beans.factory.xml;

import com.demo.myspring.beans.PropertyValue;
import com.demo.myspring.beans.factory.config.BeanDefinition;
import com.demo.myspring.beans.factory.support.AbstractBeanDefinition;
import com.demo.myspring.beans.factory.support.AbstractBeanDefinitionReader;
import com.demo.myspring.beans.factory.support.BeanDefinitionRegistry;
import com.demo.myspring.beans.factory.support.BeanReference;
import com.demo.myspring.core.io.Resource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;

/**
 * Created by Marter on 6/25/18.
 */
public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {

    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry) {
        super(registry);
    }

    @Override
    public int loadBeanDefinitions(Resource resource) {
        InputStream inputStream = resource.getInputStream();
        doLoadBeanDefinitions(inputStream);

        return 1;
    }

    @Override
    public int loadBeanDefinitions(Resource[] resources) {
        int count = 0;
        for (int i = 0; i < resources.length; i++) {
            count += loadBeanDefinitions(resources[i]);
        }
        return count;
    }

    /**
     * Load bean definitions from the input steram of specified bean.
     *
     * @param inputStream
     */
    public void doLoadBeanDefinitions(InputStream inputStream) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = factory.newDocumentBuilder();
            Document doc = docBuilder.parse(inputStream);
            Element root = doc.getDocumentElement();
            NodeList nl = root.getChildNodes();
            for (int i = 0; i < nl.getLength(); i++) {
                Node node = nl.item(i);
                if (node instanceof Element) {
                    Element ele = (Element)node;
                    processBeanDefinition(ele);
                }
            }
            inputStream.close();
        } catch (Exception e) {

        }
    }

    /**
     * Load bean definition from xml element. Only support property type of String, String list or bean reference.
     *
     * @param ele
     */
    protected void processBeanDefinition(Element ele) {
        String name = ele.getAttribute("id");
        String className = ele.getAttribute("class");
        if (name == null || className == null) {
            return;
        }

        BeanDefinition beanDefinition = new AbstractBeanDefinition();
        beanDefinition.setBeanClassName(className);
        Class clazz = null;
        try {
            clazz = Class.forName(className);
        } catch (ClassNotFoundException e) {

        }
        if (clazz == null) {
            return;
        }
        beanDefinition.setBeanClass(clazz);

        NodeList propertyNode = ele.getElementsByTagName("property");
        for (int i = 0; i < propertyNode.getLength(); i++) {
            Node node = propertyNode.item(i);
            if (node instanceof Element) {
                Element propertyEle = (Element)node;
                String propertyName = propertyEle.getAttribute("name");
                String propertyValue = propertyEle.getAttribute("value");
                String ref = propertyEle.getAttribute("ref");
                if (propertyName == null || propertyName.isEmpty()) {
                    continue;
                }
                if (propertyValue != null && !propertyValue.isEmpty()) {
                    parseStringElement(beanDefinition, propertyEle, propertyName);
                } else {
                    if (ref != null && !ref.isEmpty()) {
                        parseBeanRefElement(beanDefinition, propertyEle, propertyName);
                    } else {
                        NodeList listNodeList = propertyEle.getElementsByTagName("list");
                        if (listNodeList.getLength() == 1) {
                            parseStringListElement(beanDefinition, propertyEle, propertyName);
                        }
                    }
                }
            }
        }

        beanDefinition.setBeanClassName(className);
        getRegistry().registerBeanDefinition(name, beanDefinition);
    }


    private void parseBeanRefElement(BeanDefinition beanDefinition, Element element, String propertyName) {
        String ref = element.getAttribute("ref");
        BeanReference beanReference = new BeanReference();
        beanReference.setBeanName(ref);
        beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue(propertyName, beanReference));
    }

    private void parseStringElement(BeanDefinition beanDefinition, Element element, String propertyName) {
        String propertyValue = element.getAttribute("value");
        beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue(propertyName, propertyValue));
    }

    private void parseStringListElement(BeanDefinition beanDefinition, Element element, String propertyName) {
        NodeList valueNodeList = element.getElementsByTagName("value");
        int length = valueNodeList.getLength();
        if (length > 0) {
            String[] strArray = new String[length];
            for (int j = 0; j < length; j++) {
                Node valueNode = valueNodeList.item(j);
                strArray[j] = valueNode.getTextContent();
            }
            beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue(propertyName, strArray));
        }
    }
}
