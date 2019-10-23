package com.ipartek.formacion.springmvcsesion;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class TareasLista {
	private ArrayList<String> tareas = new ArrayList<>();
	
	public TareasLista() {
		tareas.add("UNA");
		tareas.add("DOS");
	}

	public void addTarea(String tarea) {
		tareas.add(tarea);
	}
	
	@Override
	public String toString() {
		return "TareasLista [tareas=" + tareas + "]";
	}
}
