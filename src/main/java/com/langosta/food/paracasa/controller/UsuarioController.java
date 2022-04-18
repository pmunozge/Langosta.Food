package com.langosta.food.paracasa.controller;

import com.langosta.food.paracasa.model.Menu;
import com.langosta.food.paracasa.model.Usuario;
import com.langosta.food.paracasa.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UsuarioController {

    @Autowired
    UsuarioService service;

    @PostMapping("/usuario/save")
    public String saveUsuario(Usuario usuario, RedirectAttributes ra){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        Usuario user = new Usuario();

        user.setPassword(encoder.encode(usuario.getPassword()));
        user.setNombre(usuario.getNombre());

        service.save(user);
        /*user.setNombre("langosta");
        user.setPassword(encoder.encode("food"));
        service.save(user);
        return "redirect:/menus";*/
        ra.addFlashAttribute("message","El usuario ha sido guardado con éxito.");
        return "redirect:/login";
        }

    @GetMapping("/register")
    public String showNewForm(Model model){
        model.addAttribute("usuario", new Usuario());
        //model.addAttribute("pageTitle", "¡ParaCasa! Añadir un nuevo menú " );
        return "registro_form";
    }
/*
    @GetMapping("/login")
    public String showLogin(Model model){
        //model.addAttribute("usuario", new Usuario());
        //model.addAttribute("pageTitle", "¡ParaCasa! Añadir un nuevo menú " );
        return "login";
    }
*/
}
