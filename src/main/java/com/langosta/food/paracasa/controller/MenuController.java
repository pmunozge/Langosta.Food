package com.langosta.food.paracasa.controller;

import com.langosta.food.paracasa.exception.MenuNotFoundException;
import com.langosta.food.paracasa.model.Menu;
import com.langosta.food.paracasa.services.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class MenuController {
    @Autowired private MenuService service;

    @GetMapping("/menus")
    public String showMenuList(Model model){
        List<Menu> listMenus = service.listAll();
        model.addAttribute("listMenus",listMenus);

        return "menus";
    }

    @GetMapping("/menus/new")
    public String showNewForm(Model model){
        model.addAttribute("menu", new Menu());
        model.addAttribute("pageTitle", "¡ParaCasa! Añadir un nuevo menú " );
        return "menu_form";
    }
    @PostMapping("/menus/save")
    public String saveMenu(Menu menu, RedirectAttributes ra){
        service.save(menu);
        ra.addFlashAttribute("message","El menú ha sido guardado con éxito.");
        return "redirect:/menus";
    }
    @GetMapping("/menus/edit/{idmenu}")
    public String showEditForm(@PathVariable("idmenu")Integer idmenu, Model model, RedirectAttributes ra){
        try{
            Menu menu = service.get(idmenu);
            model.addAttribute("menu",menu);
            model.addAttribute("pageTitle", "¡ParaCasa! Editar un menú " );

            return "menu_form";
        }catch (MenuNotFoundException e){
            ra.addFlashAttribute("message",e.getMessage());
           // e.printStackTrace();
            return "redirect:/menus";
        }


    }

    @GetMapping("/menus/delete/{idmenu}")
    public String deleteUser(@PathVariable("idmenu")Integer idmenu,  RedirectAttributes ra){
        try{
            service.delete(idmenu);
            ra.addFlashAttribute("message", "El menú con ID "+ idmenu + " ha sido eliminado.");
        }catch (MenuNotFoundException e){
            ra.addFlashAttribute("message",e.getMessage());
            // e.printStackTrace();

        }
        return "redirect:/menus";

    }


}
