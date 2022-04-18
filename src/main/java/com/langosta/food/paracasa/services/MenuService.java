package com.langosta.food.paracasa.services;


import com.langosta.food.paracasa.exception.MenuNotFoundException;
import com.langosta.food.paracasa.model.Menu;
import com.langosta.food.paracasa.model.MenuRepository;
import com.langosta.food.paracasa.model.Producto;
import com.langosta.food.paracasa.model.Tipo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuService {
    @Autowired private MenuRepository repo;

    public List<Menu> listAll(){
        return (List<Menu>) repo.findAll();
    }
    public void save(Menu menu){
        repo.save(menu);
    }
    public Menu get(Integer idmenu) throws MenuNotFoundException {
        Optional<Menu> result=repo.findById(idmenu);
        if(result.isPresent()){
            return result.get();
        }
        throw new MenuNotFoundException("No se ha encontrado ningún menú con ese el id " + idmenu + ".");
    }
    public void delete(Integer idmenu) throws MenuNotFoundException {
        /*Long count = repo.countById(idmenu); *//* Problema por resolver*//*
        if(count != null|| count ==0){
            throw new MenuNotFoundException("No se ha encontrado ningún menú con ese el id " + idmenu + ".");
        }*/
        repo.deleteById(idmenu);
    }
}