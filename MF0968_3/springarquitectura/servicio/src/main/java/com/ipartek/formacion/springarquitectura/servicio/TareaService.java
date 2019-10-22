package com.ipartek.formacion.springarquitectura.servicio;

import java.util.logging.Logger;

import javax.inject.Inject;
import javax.inject.Named;

import com.ipartek.formacion.springarquitectura.entidades.Tarea;
import com.ipartek.formacion.springarquitectura.repositorio.TareaDao;

@Named // @Service o @Component
public class TareaService {
	private Logger log = Logger.getLogger("TAREASERVICE");
	
	@Inject
	private TareaDao dao;
	
	public Iterable<Tarea> getAll() {
		log.info("Se han pedido todos los registros de tarea");
		return dao.getAll();
	}
}
