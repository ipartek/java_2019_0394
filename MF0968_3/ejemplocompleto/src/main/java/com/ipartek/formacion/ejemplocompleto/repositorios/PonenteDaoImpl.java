package com.ipartek.formacion.ejemplocompleto.repositorios;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.ipartek.formacion.ejemplocompleto.entidades.Ponente;

@Repository
public class PonenteDaoImpl implements PonenteDao {

	private PonenteRepository ponenteRepository;
	
	public PonenteDaoImpl(PonenteRepository ponenteRepository) {
		ArrayList<Ponente> ponentes = new ArrayList<>();

		ponentes.add(new Ponente(1L, "Javier Lete", "Va a decir cosas mu chulas de muchas tecnologías..."));
		ponentes.add(new Ponente(2L, "Laura López", "Hablará sobre los nombres comunes utilizados en programación"));
		ponentes.add(new Ponente(3L, "Paco Pérez", "Hablará de los porteadores"));
		
		ponenteRepository.saveAll(ponentes);
		
		this.ponenteRepository = ponenteRepository;
	}
	
	@Override
	public Iterable<Ponente> getPonentes() {
				
		return ponenteRepository.findAll();
	}

	@Override
	public Ponente insertPonente(Ponente ponente) {
		return ponenteRepository.save(ponente);
	}
}
