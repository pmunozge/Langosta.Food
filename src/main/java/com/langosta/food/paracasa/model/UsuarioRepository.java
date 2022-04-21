package com.langosta.food.paracasa.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {
    //Usuario findBynombre(String nombre);
    Optional<Usuario> findByNombre(String nombreUsuario);
    boolean existsByNombre(String nombreUsuario);
}
