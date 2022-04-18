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

    @PostMapping("/usuarioTest")
    public String saveMenu(){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        Usuario user = new Usuario();
        user.setNombre("langosta");
        user.setPassword(encoder.encode("food"));
        service.save(user);
        return "redirect:/menus";
    }


}
