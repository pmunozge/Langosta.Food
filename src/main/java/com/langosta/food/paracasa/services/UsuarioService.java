package com.langosta.food.paracasa.services;

import com.langosta.food.paracasa.model.Usuario;
import com.langosta.food.paracasa.model.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService/* implements UserDetailsService*/ {

    @Autowired
    private UsuarioRepository repo;

 /*   @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> us = repo.findByNombre(username);

        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority("ADMIN"));

        UserDetails userDet = new User(us.getNombre(), us.getPassword(), roles);

        return userDet;

    }*/

    public void save(Usuario user){
        repo.save(user);
    }


    public List<Usuario> lista(){
        return (List<Usuario>) repo.findAll();
    }

    public Optional<Usuario> getById(int id){
        return repo.findById(id);
    }

    public Optional<Usuario> getByNombre(String nombreUsuario){
        return repo.findByNombre(nombreUsuario);
    }


    public boolean existsById(int id){
        return repo.existsById(id);
    }

    public boolean existsByNombre(String nombreUsuario){
        return repo.existsByNombre(nombreUsuario);
    }

}
