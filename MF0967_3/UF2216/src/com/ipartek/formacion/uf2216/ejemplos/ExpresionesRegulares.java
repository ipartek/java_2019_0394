package com.ipartek.formacion.uf2216.ejemplos;

public class ExpresionesRegulares {

	public static void main(String[] args) {
		// https://regexr.com/
		// https://www.regular-expressions.info/
		System.out.println("12-12-1234".matches("^\\d\\d\\-1?\\d\\-\\d{4}$"));
	}

}
