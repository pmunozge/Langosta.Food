package com.langosta.food.paracasa.services;

import com.langosta.food.paracasa.model.MenuRepository;
import com.langosta.food.paracasa.model.Producto;
import com.langosta.food.paracasa.model.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {
    @Autowired private ProductoRepository repo;

    public List<Producto> listAll(){
        return (List<Producto>) repo.findAll();
    }
}
