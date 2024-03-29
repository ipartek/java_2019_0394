package com.ipartek.formacion.spring.springbasico;

public class StandardOutMessageRenderer implements MessageRenderer {
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
