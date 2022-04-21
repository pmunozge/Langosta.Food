package com.langosta.food.paracasa.security.service;

import com.langosta.food.paracasa.model.Usuario;
import com.langosta.food.paracasa.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UsuarioService usuarioService;

    @Override
    public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
        Usuario usuario = usuarioService.getByNombre(nombreUsuario).orElseThrow(()-> new UsernameNotFoundException(nombreUsuario));
        return UsuarioPrincipal.build(usuario);
    }
}