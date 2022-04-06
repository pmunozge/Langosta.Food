package com.langosta.food.paracasa.services;

import com.langosta.food.paracasa.exception.MenuNotFoundException;
import com.langosta.food.paracasa.model.Menu;
import com.langosta.food.paracasa.model.MenuRepository;
import com.langosta.food.paracasa.model.Producto;
import com.langosta.food.paracasa.model.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {
    @Autowired private ProductoRepository repo;

    public List<Producto> listAll(){
        return (List<Producto>) repo.findAll();
    }

    public void save(Producto producto){
        repo.save(producto);
    }

    public Producto get(Integer idproducto) throws MenuNotFoundException {
        Optional<Producto> result=repo.findById(idproducto);
        if(result.isPresent()){
            return result.get();
        }
        throw new MenuNotFoundException("No se ha encontrado ningún producto con ese el id " + idproducto + ".");
    }



    public void delete(Integer idproducto)throws MenuNotFoundException {
        Optional<Producto> result = repo.findById(idproducto);
        repo.deleteById(idproducto);

        if(!result.isPresent()){
            throw new MenuNotFoundException("No se ha encontrado ningún producto con ese el id " + idproducto + ".");
        }
        repo.deleteById(idproducto);
    }
}
