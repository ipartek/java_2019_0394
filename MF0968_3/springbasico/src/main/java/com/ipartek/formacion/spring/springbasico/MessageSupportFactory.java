package com.ipartek.formacion.spring.springbasico;

import java.util.Properties;

public class MessageSupportFactory {
	private static MessageSupportFactory instance = null;
	private Properties props = null;
	private MessageRenderer renderer = null;
	private MessageProvider provider = null;
	
	static {
		instance = new MessageSupportFactory();
	}
	
	private MessageSupportFactory() {
		props = new Properties();
		try {
			props.load(App.class.getResourceAsStream("/springbasico.properties"));
			// get the implementation classes
			String rendererClass = props.getProperty("renderer.class");
			String providerClass = props.getProperty("provider.class");
			renderer = (MessageRenderer) Class.forName(rendererClass).newInstance();
			provider = (MessageProvider) Class.forName(providerClass).newInstance();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static MessageSupportFactory getInstance() {
		return instance;
	}

	public MessageRenderer getMessageRenderer() {
		return renderer;
	}

	public MessageProvider getMessageProvider() {
		return provider;
	}
}
