package com.ipartek.formacion.ejemplocompleto.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.ejemplocompleto.entidades.Ponente;
import com.ipartek.formacion.ejemplocompleto.repositorios.PonenteDao;

@Service
public class PonenteServiceImpl implements PonenteService {
	@Autowired
	private PonenteDao ponenteDao;
	
	@Override
	public Iterable<Ponente> getPonentes() {
		return ponenteDao.getPonentes();
	}
	
	@Override
	public Ponente addPonente(Ponente ponente) {
		return ponenteDao.insertPonente(ponente);
	}
}
