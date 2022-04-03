package com.langosta.food.paracasa.controller;

import com.langosta.food.paracasa.model.Menu;
import com.langosta.food.paracasa.model.Producto;
import com.langosta.food.paracasa.services.MenuService;
import com.langosta.food.paracasa.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProductoController {
    @Autowired
    private ProductoService service;

    @GetMapping("/productos")
    public String showMenuList(Model model){

        List<Producto> listProductos = service.listAll();
        model.addAttribute("listProductos",listProductos);//vinculación con el html

        return "productos";//archivo html
    }

    @GetMapping("/productos/new")
    public String showNewFormProducto(Model model){
        model.addAttribute("producto", new Producto());
        model.addAttribute("pageTitle", "¡ParaCasa! Añadir un nuevo prodcuto" );
        return "prodcuto_form";//archivo html
    }


}
