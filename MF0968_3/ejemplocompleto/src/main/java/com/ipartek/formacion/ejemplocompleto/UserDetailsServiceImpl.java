package com.ipartek.formacion.ejemplocompleto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import com.ipartek.formacion.ejemplocompleto.entidades.Usuario;
import com.ipartek.formacion.ejemplocompleto.repositorios.UsuarioRepository;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarios;

    @Override
    public UserDetails loadUserByUsername(String nick) {

        Usuario usuario = usuarios.findByNick(nick);
        
        List<SimpleGrantedAuthority> auths = new ArrayList<>();
        auths.add(new SimpleGrantedAuthority(usuario.getRol()));

        return new User(usuario.getNick(), usuario.getPassword(), auths);
    }
}