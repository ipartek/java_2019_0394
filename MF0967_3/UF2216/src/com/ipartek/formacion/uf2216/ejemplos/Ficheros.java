package com.ipartek.formacion.uf2216.ejemplos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Ficheros {

	private static final String RUTA_FICHERO = "C:\\trabajos\\nuevo.txt";
	private static final boolean AUTO_FLUSH = true;
	private static final boolean APPEND = true;

	public static void main(String[] args) throws IOException {
		FileWriter fw = new FileWriter(RUTA_FICHERO, APPEND);
		PrintWriter pw = new PrintWriter(fw, AUTO_FLUSH);
		
		pw.println("Una");
		
		//pw.flush();
		
		pw.println("Dos");
		
		pw.close();
		fw.close();
		
		FileReader fr = new FileReader(RUTA_FICHERO);
		BufferedReader br = new BufferedReader(fr);
		
		String linea;
		
		int numero = 1;
		
		while( (linea = br.readLine()) != null) {
			System.out.println(numero++ + ": " + linea);
		}
		
	}

}
