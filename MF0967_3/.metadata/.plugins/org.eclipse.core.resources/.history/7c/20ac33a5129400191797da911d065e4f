package com.ipartek.formacion.uf2216.ejemplos.threads;

public class Carrera {

	public static void main(String[] args) {
		Corredor c1 = new Corredor("C1", 10);
		Corredor c2 = new Corredor("C2", 10);
		
		Thread t1 = new Thread(c1);
		Thread t2 = new Thread(c2);
		
		t1.start();
		t2.start();
		
		int pos1, pos2;
		
		do {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				
			}
			
			pos1 = c1.getPosicion();
			pos2 = c2.getPosicion();
			
			System.out.println(c1);
			System.out.println(c2);
		} while(pos1 != 10 && pos2 != 10);
	}

}
