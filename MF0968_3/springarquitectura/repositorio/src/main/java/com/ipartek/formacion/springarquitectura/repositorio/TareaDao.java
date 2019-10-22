package com.ipartek.formacion.springarquitectura.repositorio;

import com.ipartek.formacion.springarquitectura.entidades.Tarea;

public interface TareaDao extends Dao<Long, Tarea> {
	Iterable<Tarea> findByTareasPendientes();
	Iterable<Tarea> findByTareasTerminadas();
}
