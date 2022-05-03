package com.langosta.food.paracasa;

import com.langosta.food.paracasa.model.Menu;
import com.langosta.food.paracasa.services.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/menus")
public class RestApi {

    @Autowired
    private MenuService repo;


    @GetMapping
    public List<Menu> listar(){
        return repo.listAll();

    }

    @PostMapping
    public void insertar(@RequestBody Menu menu){//Con esta notacion Spring coge el JSOn y lo transforma en objeto
        repo.save(menu);
    }

    /*LO que hay que poner en postman
    {

    "enabled": true,
    "nombre": "ProbandoJson",
    "precio": 22

     }
     */
}
