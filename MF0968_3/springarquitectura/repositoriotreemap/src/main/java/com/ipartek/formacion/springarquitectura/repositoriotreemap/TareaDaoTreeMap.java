package com.ipartek.formacion.springarquitectura.repositoriotreemap;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.TreeMap;

import javax.inject.Named;

import com.ipartek.formacion.springarquitectura.entidades.Tarea;
import com.ipartek.formacion.springarquitectura.repositorio.TareaDao;

@Named //@Repository o @Component de javax.inject
public class TareaDaoTreeMap implements TareaDao {

	private TreeMap<Long, Tarea> tareas = new TreeMap<>();

	public TareaDaoTreeMap() {
		tareas.put(1L, new Tarea(1L, "Tarea 1", false, LocalDate.now(), LocalDate.now()));
		tareas.put(2L, new Tarea(2L, "Tarea 2", true, LocalDate.now(), LocalDate.now()));
	}
	
	@Override
	public Iterable<Tarea> getAll() {
		return tareas.values();
	}

	@Override
	public Tarea getById(Long id) {
		return tareas.get(id);
	}

	@Override
	public Tarea insert(Tarea tarea) {
		Long id = tareas.lastKey() + 1;
		tarea.setId(id);

		tareas.put(id, tarea);

		return tarea;
	}

	@Override
	public Tarea update(Tarea tarea) {
		tareas.put(tarea.getId(), tarea);

		return tarea;
	}

	@Override
	public void delete(Long id) {
		tareas.remove(id);
	}

	@Override
	public Iterable<Tarea> findByTareasPendientes() {
		// return tareas.values().stream().filter(tarea ->
		// !tarea.isTerminada()).iterator();
		ArrayList<Tarea> pendientes = new ArrayList<>();

		for (Tarea tarea : tareas.values()) {
			if (!tarea.isTerminada()) {
				pendientes.add(tarea);
			}
		}

		return pendientes;
	}

	@Override
	public Iterable<Tarea> findByTareasTerminadas() {
		// return tareas.values().stream().filter(tarea ->
		// !tarea.isTerminada()).iterator();
		ArrayList<Tarea> terminadas = new ArrayList<>();

		for (Tarea tarea : tareas.values()) {
			if (tarea.isTerminada()) {
				terminadas.add(tarea);
			}
		}

		return terminadas;
	}

}
