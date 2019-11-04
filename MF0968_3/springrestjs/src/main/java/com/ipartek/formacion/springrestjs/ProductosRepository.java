package com.ipartek.formacion.springrestjs;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ipartek.formacion.springrestjs.entidades.Producto;

@RepositoryRestResource(collectionResourceRel = "productos", path = "productos")
public interface ProductosRepository extends PagingAndSortingRepository<Producto, Long> {

}