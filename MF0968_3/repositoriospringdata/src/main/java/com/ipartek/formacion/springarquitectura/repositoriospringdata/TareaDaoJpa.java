package com.ipartek.formacion.springarquitectura.repositoriospringdata;

import java.time.LocalDate;

import javax.inject.Inject;
import javax.inject.Named;

import com.ipartek.formacion.springarquitectura.entidades.Tarea;
import com.ipartek.formacion.springarquitectura.repositorio.TareaDao;

@Named
public class TareaDaoJpa implements TareaDao {
	
	private TareaRepository repositorio;
	
	@Inject
	public TareaDaoJpa(TareaRepository repositorio) {
		this.repositorio = repositorio;
		
		insert(new Tarea(null, "Tarea 1 MySQL", false, LocalDate.now(), LocalDate.now()));
		insert(new Tarea(null, "Tarea 2 MySQL", true, LocalDate.now(), LocalDate.now()));
		insert(new Tarea(null, "Tarea 3 MySQL", true, LocalDate.now(), LocalDate.now()));
	}
	
	@Override
	public Iterable<Tarea> getAll() {
		return repositorio.findAll(); 
	}

	@Override
	public Tarea getById(Long id) {
		return repositorio.findById(id).get();
	}

	@Override
	public Tarea insert(Tarea tarea) {
		tarea.setId(null);
		return repositorio.save(tarea);
	}

	@Override
	public Tarea update(Tarea tarea) {
		return repositorio.save(tarea);
	}

	@Override
	public void delete(Long id) {
		repositorio.deleteById(id);
	}

	@Override
	public Iterable<Tarea> findByTareasPendientes() {
		return repositorio.findByTerminada(false);
	}

	@Override
	public Iterable<Tarea> findByTareasTerminadas() {
		return repositorio.findByTerminada(true);
	}

}
