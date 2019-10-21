package com.ipartek.formacion.spring.springbootbasico;

public class HelloWorldMessageProvider implements MessageProvider {

	@Override
	public String getMessage() {
		return "Hola Mundo";
	}

}
