package com.ipartek.formacion.uf2216.ejemplos.threads;

public class Corredor implements Runnable {
	private String dorsal;
	private int posicion = 0;
	private int meta = 0;
	
	public Corredor(String dorsal, int meta) {
		this.dorsal = dorsal;
		this.meta = meta;
	}
	
	public void correr() {
		for(posicion = 0; posicion <= meta; posicion++) {
			try {
				Thread.sleep((int)(Math.random() * 1000));
			} catch (InterruptedException e) {
				// QUIERO IGNORAR LA EXCEPCION DE INTERRUPCION DEL THREAD
			}
		}
	}
	
	public int getPosicion() {
		return posicion;
	}

	public String getDorsal() {
		return dorsal;
	}
	
	@Override
	public void run() {
		correr();
	}

	@Override
	public String toString() {
		return "Corredor [dorsal=" + dorsal + ", posicion=" + posicion + ", meta=" + meta + "]";
	}
	
	
}
