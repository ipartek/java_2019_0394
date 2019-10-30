package com.ipartek.formacion.springresumen;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ipartek.formacion.springresumen.modelo.Usuario;

@RepositoryRestResource(collectionResourceRel = "usuarios", path = "usuarios")
public interface UsuarioRepository extends PagingAndSortingRepository<Usuario, Long> {
	List<Usuario> findByNombre(String nombre);
	List<Usuario> findByEmail(String email);

	Usuario findById(long id);
}
