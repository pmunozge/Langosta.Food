package com.langosta.food.paracasa.services;


import com.langosta.food.paracasa.enums.RolNombre;
import com.langosta.food.paracasa.model.Rol;
import com.langosta.food.paracasa.model.RolRepository;
import com.langosta.food.paracasa.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RolService {

    @Autowired
    RolRepository rolRepository;

    public List<Rol> lista(){
        return (List<Rol>) rolRepository.findAll();
    }

    public void save(Rol rol){
        rolRepository.save(rol);
    }

    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return rolRepository.findByRolNombre(rolNombre);
    }

    public boolean existsByRolNombre(RolNombre rolNombre){
        return rolRepository.existsByRolNombre(rolNombre);
    }
}