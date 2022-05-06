package com.langosta.food.paracasa;

import com.langosta.food.paracasa.model.Menu;
import com.langosta.food.paracasa.model.Pedido;
import com.langosta.food.paracasa.model.Producto;
import com.langosta.food.paracasa.model.Usuario;
import com.langosta.food.paracasa.services.MenuService;
import com.langosta.food.paracasa.services.PedidoService;
import com.langosta.food.paracasa.services.ProductoService;
import com.langosta.food.paracasa.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/api/menus")
public class RestApi {

    @Autowired
    private MenuService repo;
    @Autowired
    private PedidoService repoPedido;
    @Autowired
    private UsuarioService repoUsuario;
    @Autowired
    private ProductoService repoProducto;


    @GetMapping("/api/menus")
    public List<Menu> listar(){
        return repo.listAll();

    }

    @PostMapping("/api/menus")
    public void insertarMenu(@RequestBody Menu menu){//Con esta notacion Spring coge el JSOn y lo transforma en objeto
        repo.save(menu);
    }

    /*Lo que hay que poner en postman
    {

    "enabled": true,
    "nombre": "ProbandoJson",
    "precio": 22

     }
     */

    @GetMapping("/securedapi/pedidos")
    public List<Pedido> listarPedidos(){
        return repoPedido.listAll();
    }

    @GetMapping("/securedapi/usuarios")
    public List<Usuario> listarUsuarios(){
        return repoUsuario.lista();
    }

    @PostMapping("/securedapi/productos")
    public void insertarProdcuto(@RequestBody Producto producto){//Con esta notacion Spring coge el JSOn y lo transforma en objeto
        repoProducto.save(producto);
    }

}
