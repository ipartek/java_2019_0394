package com.ipartek.formacion.uf2216.ejemplos.poo;

import java.util.ArrayList;

public class LambdaPrueba {

	public static void main(String[] args) {
		ArrayList<String> al = new ArrayList<String>();

		al.add("Uno");
		al.add("Dos");

		for(Object dato: al.stream().filter((dato) -> dato.contains("U")).toArray()){
			System.out.println(dato);
		}
	}
}
