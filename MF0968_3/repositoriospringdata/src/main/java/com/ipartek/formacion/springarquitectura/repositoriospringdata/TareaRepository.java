package com.ipartek.formacion.springarquitectura.repositoriospringdata;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ipartek.formacion.springarquitectura.entidades.Tarea;

public interface TareaRepository extends CrudRepository<Tarea, Long> {
	List<Tarea> findByTerminada(boolean terminada);
}
