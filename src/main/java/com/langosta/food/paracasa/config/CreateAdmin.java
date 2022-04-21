package com.langosta.food.paracasa.config;


import com.langosta.food.paracasa.enums.RolNombre;
import com.langosta.food.paracasa.model.Rol;
import com.langosta.food.paracasa.model.Usuario;
import com.langosta.food.paracasa.services.RolService;
import com.langosta.food.paracasa.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class CreateAdmin implements CommandLineRunner {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    RolService rolService;

    @Override
    public void run(String... args) throws Exception {

    }
}