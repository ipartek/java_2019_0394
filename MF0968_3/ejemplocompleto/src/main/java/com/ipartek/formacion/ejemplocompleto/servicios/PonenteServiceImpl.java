package com.ipartek.formacion.ejemplocompleto.servicios;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.ipartek.formacion.ejemplocompleto.entidades.Ponente;

@Service
public class PonenteServiceImpl implements PonenteService {
	@Override
	public Iterable<Ponente> getPonentes() {
		ArrayList<Ponente> ponentes = new ArrayList<>();

		ponentes.add(new Ponente(1L, "Javier Lete", "Va a decir cosas mu chulas de muchas tecnologías..."));
		ponentes.add(new Ponente(2L, "Laura López", "Hablará sobre los nombres comunes utilizados en programación"));
		ponentes.add(new Ponente(3L, "Paco Pérez", "Hablará de los porteadores"));

		return ponentes;
	}
}
