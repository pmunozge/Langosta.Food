package com.langosta.food.paracasa.controller;

import com.langosta.food.paracasa.exception.MenuNotFoundException;
import com.langosta.food.paracasa.model.Menu;
import com.langosta.food.paracasa.model.Producto;
import com.langosta.food.paracasa.services.MenuService;
import com.langosta.food.paracasa.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProductoController {
    @Autowired
    private ProductoService service;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/productos")
    public String showMenuList(Model model){

        List<Producto> listProductos = service.listAll();
        model.addAttribute("listProductos",listProductos);//vinculación con el html

        return "productos";//archivo html
    }

    @GetMapping("/productos/new")
    public String showNewFormProducto(Model model){
        model.addAttribute("producto", new Producto());
        model.addAttribute("pageTitle", "¡ParaCasa! Añadir un nuevo plato" );
        return "producto_form";
    }

    @PostMapping("productos/save")
    public String saveMenu(Producto producto, RedirectAttributes ra){
        service.save(producto);
        ra.addFlashAttribute("message","El producto ha sido guardado con éxito.");
        return "redirect:/productos";
    }

    @GetMapping("/productos/edit/{idproducto}")
    public String showEditForm(@PathVariable("idproducto")Integer idproducto, Model model, RedirectAttributes ra) {
        try {
            Producto producto = service.get(idproducto);
            model.addAttribute("producto", producto);
            model.addAttribute("pageTitle", "Edición de plato ");

            return "producto_form";
        } catch (MenuNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
            // e.printStackTrace();
            return "redirect:/productos";
        }
    }

    @GetMapping("/productos/delete/{idproducto}")
    public String borrar(@PathVariable("idproducto")Integer idproducto, Model model, RedirectAttributes ra) {
        try {
            service.delete(idproducto);
            ra.addFlashAttribute("message","El producto ha sido borrado con éxito.");

        } catch (MenuNotFoundException e) {

            e.printStackTrace();
        }
        return "redirect:/productos";
    }


}