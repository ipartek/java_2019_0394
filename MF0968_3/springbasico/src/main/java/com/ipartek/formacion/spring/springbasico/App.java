package com.ipartek.formacion.spring.springbasico;

import java.util.Properties;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;

public class App {
	public static void main(String[] args) throws Exception {
		BeanFactory factory = getBeanFactory();
		
		MessageRenderer mr = (MessageRenderer) factory.getBean("renderer");
		
		mr.render();
	}

	private static BeanFactory getBeanFactory() throws Exception {
		// get the bean factory
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		// create a definition reader
		PropertiesBeanDefinitionReader rdr = new PropertiesBeanDefinitionReader(factory);
		// load the configuration options
		Properties props = new Properties();
		props.load(App.class.getResourceAsStream("/springbasico.properties"));
		rdr.registerBeanDefinitions(props);
		return factory;
	}
}
