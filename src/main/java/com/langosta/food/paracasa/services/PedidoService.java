package com.langosta.food.paracasa.services;

import com.langosta.food.paracasa.exception.MenuNotFoundException;
import com.langosta.food.paracasa.model.Menu;
import com.langosta.food.paracasa.model.MenuRepository;
import com.langosta.food.paracasa.model.Pedido;
import com.langosta.food.paracasa.model.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repo;

    public List<Pedido> listAll(){
        return (List<Pedido>) repo.findAll();
    }

    public void save(Pedido pedido){
        repo.save(pedido);
    }

    public Pedido get(Integer idpedido) throws MenuNotFoundException {
        Optional<Pedido> result=repo.findById(idpedido);
        if(result.isPresent()){
            return result.get();
        }
        throw new MenuNotFoundException("No se ha encontrado ningún menú con ese el id " + idpedido + ".");
    }
    public void delete(Integer idpedido) throws MenuNotFoundException {
        /*Long count = repo.countById(idmenu); *//* Problema por resolver*//*
        if(count != null|| count ==0){
            throw new MenuNotFoundException("No se ha encontrado ningún menú con ese el id " + idmenu + ".");
        }*/
        repo.deleteById(idpedido);
    }
}