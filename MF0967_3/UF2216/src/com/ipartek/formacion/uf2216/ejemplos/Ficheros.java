package com.ipartek.formacion.uf2216.ejemplos;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;

public class Ficheros {

	private static final String RUTA_FICHERO_BINARIO = "C:\\trabajos\\objetos.dat";
	private static final String RUTA_FICHERO = "C:\\trabajos\\nuevo.txt";
	private static final boolean AUTO_FLUSH = true;
	private static final boolean APPEND = true;

	static class Usuario implements Serializable {
		private static final long serialVersionUID = 3009597636195142884L;
		
		private int id;
		private String nombre;
		
		public Usuario(int id, String nombre) {
			super();
			this.id = id;
			this.nombre = nombre;
		}
		
		@Override
		public String toString() {
			return "Usuario [id=" + id + ", nombre=" + nombre + "]";
		}
	}
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		FileOutputStream fos = new FileOutputStream(RUTA_FICHERO_BINARIO);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		oos.writeObject(new Usuario(1, "Javier"));
		
		oos.close();
		fos.close();
		
		FileInputStream fis = new FileInputStream(RUTA_FICHERO_BINARIO);
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		Usuario usuario = (Usuario) ois.readObject();
		
		ois.close();
		fis.close();
		
		System.out.println(usuario);
	}
	
	public static void mainTexto(String[] args) throws IOException {
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
		
		br.close();
		fr.close();
	}

}
