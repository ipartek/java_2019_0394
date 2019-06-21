package com.ipartek.formacion.uf2216.ejemplos.sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {

	private static final boolean AUTO_FLUSH = true;

	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket s = new Socket("localhost", 1234);
		
		BufferedReader br = new BufferedReader(
				new InputStreamReader(s.getInputStream()));
		
		PrintWriter pw = new PrintWriter(s.getOutputStream(), AUTO_FLUSH);
		
		String texto = br.readLine();
		
		System.out.println(texto);
		
		pw.println("texto en minusculas");
		
		texto = br.readLine();
		
		System.out.println(texto);
		
		pw.close();
		br.close();
		
		s.close();
	}

}
