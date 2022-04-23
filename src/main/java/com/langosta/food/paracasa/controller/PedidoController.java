package com.langosta.food.paracasa.controller;

import com.langosta.food.paracasa.exception.MenuNotFoundException;
import com.langosta.food.paracasa.model.Pedido;
import com.langosta.food.paracasa.model.Producto;
import com.langosta.food.paracasa.services.PedidoService;
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
public class PedidoController {

    @Autowired
    private PedidoService service;


    @GetMapping("/pedidos")
    public String showMenuList(Model model){

        List<Pedido> listPedidos = service.listAll();
        model.addAttribute("listProductos",listPedidos);//vinculación con el html

        return "pedidos";//archivo html
    }

        @GetMapping("/pedidos/new")
        public String showNewFormPedido(Model model){
            model.addAttribute("pedido", new Pedido());
            model.addAttribute("pageTitle", "¡ParaCasa! Añadir un nuevo pedido" );
            return "pedido_form";
        }

        @PostMapping("pedidos/save")
        public String saveMenu(Pedido pedido, RedirectAttributes ra){
            service.save(pedido);
            ra.addFlashAttribute("message","El pedido ha sido guardado con éxito.");
            return "redirect:/pedidos";
        }

        @GetMapping("/productos/edit/{idpedido}")
        public String showEditForm(@PathVariable("idpedido")Integer idpedido, Model model, RedirectAttributes ra) {
            try {
                Pedido pedido = service.get(idpedido);
                model.addAttribute("pedido", pedido);
                model.addAttribute("pageTitle", "Edición de pedido ");

                return "pedido_form";
            } catch (MenuNotFoundException e) {
                ra.addFlashAttribute("message", e.getMessage());
                // e.printStackTrace();
                return "redirect:/pedidos";
            }
        }

        @GetMapping("/pedidos/delete/{idpedido}")
        public String borrar(@PathVariable("idpedido")Integer idpedido, Model model, RedirectAttributes ra) {
            try {
                service.delete(idpedido);
                ra.addFlashAttribute("message","El pedido ha sido borrado con éxito.");

            } catch (MenuNotFoundException e) {

                e.printStackTrace();
            }
            return "redirect:/pedidos";
        }

    }
