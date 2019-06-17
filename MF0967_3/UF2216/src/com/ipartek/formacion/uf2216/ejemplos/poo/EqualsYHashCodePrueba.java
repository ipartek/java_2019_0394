package com.ipartek.formacion.uf2216.ejemplos.poo;

import java.util.ArrayList;

public class EqualsYHashCodePrueba {
	public static void main(String[] args) {
		ArrayList<PuntoGenerico<Integer,String>> puntos = new ArrayList<PuntoGenerico<Integer,String>>();
		
		PuntoGenerico<Integer,String> p = new PuntoGenerico<Integer,String>(1,2,"Primero");
		
		puntos.add(p);
		puntos.add(new PuntoGenerico<Integer,String>(3,4,"Segundo"));
		puntos.add(new PuntoGenerico<Integer,String>(5,6,"Tercero"));
		
		puntos.remove(p);
		puntos.remove(new PuntoGenerico<Integer,String>(3,4,"Segundo"));
		
		for(PuntoGenerico<Integer,String> pt: puntos) {
			System.out.println(pt);
		}
	}
	public static void mainPuntoSinEquals(String[] args) {
		ArrayList<Punto> puntos = new ArrayList<Punto>();
		
		Punto p = new Punto(1,2);
		
		puntos.add(p);
		puntos.add(new Punto(3,4));
		puntos.add(new Punto(5,6));
		
		puntos.remove(p);
		puntos.remove(new Punto(3,4));
		
		for(Punto pt: puntos) {
			System.out.println(pt);
		}
	}

}
