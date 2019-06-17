package com.ipartek.formacion.uf2216.ejemplos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class Lenguaje {

	//Lenguaje.main()
	/**
	 * Método que se llama al iniciar la aplicación
	 * @param args Argumentos de entrada de consola
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		System.out.println("Hola");
		
		// Tipos primitivos
		// ----------------
		// ENTEROS CON SIGNO
		// byte   8  -> Byte
		// short 16  -> Short
		// int   32  -> Integer
		// long  64  -> Long
		// 2^(n-1) a 2^(n-1) - 1 (complemento a dos)
		
		// COMA FLOTANTE
		// float   32 -> Float
		// double  64 -> Double
		
		// boolean 16 true o false -> Boolean
		// char    16 Unicode 'a'  -> Character
		
		int i1, i2 = 3, i3;
		
		// Resto de tipos
		
		String s1 = new String("Javi");
		String s2 = new String("Javi");
		
		System.out.println("¿Son la misma? " + (s1 == s2));
		System.out.println("¿Son iguales? " + s1.equals(s2));
		
		System.out.println(s1.toUpperCase().charAt(3));
		
		String nombre = "Javier";
		nombre = "Pepe";
		
		System.out.println(nombre);
		
		String log = "";
		log += "Mi nombre es " + nombre + " y concatenar mola";
		
		System.out.println(log);
		
		String log2 = "";
		log2 = new StringBuffer(log2)
				.append("Mi nombre es ")
				.append("nombre")
				.append(" y concatenar mola").toString();
		
		StringBuffer log3 = new StringBuffer();
		log3.append("lo que sea");
		
		int dia;
		
		dia = 5;
		
		int tamano = 3; // n, nn, ny, ni, gn
		
		int[] arr = new int[tamano];
		int[] arr2 = { 1, 2, 5, 6, 7, 7, 5, 4 };
		
		arr[0] = 4;
		arr[1] = 3;
		arr[2] = 2;
		//arr[3] = 6;
		System.out.println(arr.length);
		System.out.println(arr[1]);
		
		char[][] tablero = new char[8][4];
		
		tablero[0][0] = 'T';
		tablero[0][1] = 'C';
		
		tablero[1] = new char[] { 'P', 'P' };
		
		System.out.println(tablero[0]);
		
		System.out.println(tablero.length);
		
		System.out.println(tablero[0].length);
		
		System.out.println(tablero[1].length);
		
		char[][] tablero2 = {
				{ 'T', 'C' },
				{ 'P', 'P' }
		};
		
		ArrayList<String> lista = new ArrayList<String>();
		
		lista.add("Uno");
		lista.add("Dos");
		
		System.out.println(lista.get(0));
		
		System.out.println(lista.size());
		
		// Operadores
		
		// Aritméticos
		// +, -, *, /, % (resto de división entera)
		
		int suma = 5 + 4 + 3 + 2;
		
		// A nivel de bits
		// &, |, ^ (XOR), ~ (Complemento a 1)
		// >>, <<, >>>
		
		System.out.println(5 & 3);
		System.out.println(5 | 3);
		System.out.println(5 ^ 3);
		System.out.println(~5);
		
		System.out.println(5 >> 1);
		System.out.println(-5 >> 1);
		System.out.println(5 << 1);
		System.out.println(5 >>> 1);
		System.out.println(-5 >>> 1);
		
		// Comparación
		// <, >, <=, >=, ==, !=
		
		// Lógicos
		// (&, | Normales) (&&, || Cortocircuito), !
		
		int x = 3;
		System.out.println(1 <= x && x <= 10);
		
		// +=, -=, *=, /= ...
		
		x = x + 2;
		x += 2;
		
		// =
		
		int a, b, c;
		
		a = b = c = 10;
		
		// ++, --
		
		System.out.println(x);
		System.out.println(x++);
		System.out.println(x);
		System.out.println(++x);
		System.out.println(x);
		
		// boolean ? Object: Object
		
		boolean bool = true;
		System.out.println(bool ? "VERDADERO": "FALSO");
		
		int x1 = 5, x2 = 10;
		int res;
		res = x1 > x2 ? x1: x2;
		System.out.println(res);
		
		// Sentencias de control
		if(x1 > x2) {
			res = x1;
		} else {
			res = x2;
		}
		
		System.out.println(res);
		
		if(x1 == x2) {
			System.out.println("Son iguales");
		} else if(x1 < x2) {
			System.out.println("x1 < x2");
		} else {
			System.out.println("x1 > x2");
		}
		
		boolean isEncendido = true;
		
		if(!isEncendido) {
			System.out.println("Está apagado");
		}
		
		System.out.println(isEncendido);
		
		// switch soporta Enteros y char
		// Java5 soporta además String en switch
		
		String opcion = "uno";
		
		switch(opcion) {
		case "uno": System.out.println(1); break;
		case "dos": System.out.println(2); break;
		case "tres": System.out.println(3); break;
		}
		
		int mes = 5, dias;
		switch(mes) {
		case 2: dias = 28; break;
		case 4:
		case 6:
		case 9:
		case 11: dias = 30; break;
		default: dias = 31;
		}
		
		x = 1;
		while(x <= 10) {
			System.out.println(x);
			x++;
		}
		
		x = 1;
		do {
			System.out.println(x++);
		} while(x <= 10);
		
		for(x = 1; x <= 10; x++) {
			System.out.println(x);
		}
		
//		for(;;) {
//			System.out.println("INFINITO");
//		}
		
		// Java5
		int[] enteros = { 5, 2, 5, 78, 9, 7, 5, 3 };
		
		for(int entero: enteros) {
			System.out.println(entero);
		}
		
		for(int i = 0; i < enteros.length; i++) {
			System.out.println(enteros[i]);
		}
		
		//Cuidado con los String
		String fichero = "C:\\nuevos\\trabajos";
		
		System.out.println(fichero);
		
		// Diccionario
		HashMap<String, String> diccionario = new HashMap<String, String>();
		
		diccionario.put("casa", "home");
		diccionario.put("coche", "car");
		
		System.out.println(diccionario.get("coche"));
		
		for(String clave: diccionario.keySet()) {
			System.out.println(clave);
		}
		
		for(String valor: diccionario.values()) {
			System.out.println(valor);
		}
		
		String linea;
		
		for(Entry<String, String> par: diccionario.entrySet()) {
			linea = String.format("(%s, %s)", par.getKey(), par.getValue());
			System.out.println(linea);
		}
		
		// Conversiones
		
		String sNumero = "5";
		int iNumero = Integer.parseInt(sNumero);
		
		System.out.println(iNumero);
		
		String texto = String.valueOf(iNumero);
		
		System.out.println(texto);
		
		java.util.Date fecha = new java.util.Date();
		
		texto = fecha.toString();
		
		System.out.println(texto);
	}
}
