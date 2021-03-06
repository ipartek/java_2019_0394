package com.ipartek.formacion.uf2216.ejemplos.sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	private static final boolean AUTO_FLUSH = true;

	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket(1234);
		Socket s = ss.accept();
		
		BufferedReader br = new BufferedReader(
				new InputStreamReader(s.getInputStream()));
		
		PrintWriter pw = new PrintWriter(s.getOutputStream(), AUTO_FLUSH);
		
		pw.println("Bienvenido a MAYUSCULATOR");
		
		String texto = br.readLine();
		
		pw.println(texto.toUpperCase());
		
		pw.close();
		br.close();
		
		s.close();
		ss.close();
	}

}
