package com.ipartek.formacion.spring.springbootbasico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("simple")
public class StandardOutMessageRenderer implements MessageRenderer {
	@Autowired
	private MessageProvider messageProvider = null;

	@Override
	public void render() {
		if (messageProvider == null) {
			throw new RuntimeException(
					"You must set the property messageProvider of class:" + StandardOutMessageRenderer.class.getName());
		}
		System.out.println(getMessageProvider().getMessage());
	}

	@Override
	public void setMessageProvider(MessageProvider provider) {
		messageProvider = provider;
	}

	@Override
	public MessageProvider getMessageProvider() {
		return messageProvider;
	}

}
