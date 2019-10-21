package com.ipartek.formacion.spring.springbasico;

public class HelloWorldMessageProvider implements MessageProvider {

	@Override
	public String getMessage() {
		return "Hola Mundo";
	}

}
