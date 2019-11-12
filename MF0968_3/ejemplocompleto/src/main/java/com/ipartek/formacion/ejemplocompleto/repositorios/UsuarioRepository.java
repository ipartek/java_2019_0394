package com.ipartek.formacion.ejemplocompleto.repositorios;

import org.springframework.data.repository.CrudRepository;

import com.ipartek.formacion.ejemplocompleto.entidades.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
	Usuario findByNick(String nick);

    Usuario findById(long id);
}
