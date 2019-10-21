package com.ipartek.formacion.spring.springbootbasico;

import org.springframework.stereotype.Component;

@Component
public class HelloWorldMessageProvider implements MessageProvider {

	@Override
	public String getMessage() {
		return "Hola Mundo";
	}

}
