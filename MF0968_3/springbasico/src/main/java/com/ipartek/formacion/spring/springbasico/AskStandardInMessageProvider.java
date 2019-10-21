package com.ipartek.formacion.spring.springbasico;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AskStandardInMessageProvider implements MessageProvider {

	@Override
	public String getMessage() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("¿Qué texto quieres mostrar? ");
		try {
			return br.readLine();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
}
