package com.langosta.food.paracasa.controller;

import com.langosta.food.paracasa.model.Menu;
import com.langosta.food.paracasa.model.Producto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProductoController {

    @GetMapping("/productos")
    public String showMenuList(Model model){
        //List<Producto> listProductos = service.listAll();
        //model.addAttribute("listMenus",listMenus);

        return "menus";
    }


}
