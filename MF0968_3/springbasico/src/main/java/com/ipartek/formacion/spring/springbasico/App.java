package com.ipartek.formacion.spring.springbasico;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;

public class App {
	public static void main(String[] args) throws Exception {
		Resource config = new DefaultResourceLoader().getResource("/beans.xml");
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		new XmlBeanDefinitionReader(factory).loadBeanDefinitions(config);
		
		MessageRenderer mr = (MessageRenderer) factory.getBean("renderer");
		
		mr.render();
	}
}
