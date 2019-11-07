package com.ipartek.formacion.ejemplocompleto.repositorios;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ipartek.formacion.ejemplocompleto.entidades.Ponente;

@RepositoryRestResource(collectionResourceRel = "ponentes", path = "ponentes")
public interface PonenteRepository extends PagingAndSortingRepository<Ponente, Long>{

}
