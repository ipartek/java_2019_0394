package com.ipartek.formacion.ejemplocompleto.servicios;

import com.ipartek.formacion.ejemplocompleto.entidades.Ponente;

public interface PonenteService {

	Iterable<Ponente> getPonentes();

	Ponente addPonente(Ponente ponente);

}