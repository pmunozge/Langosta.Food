package com.langosta.food.paracasa;


import com.langosta.food.paracasa.model.Menu;
import com.langosta.food.paracasa.model.MenuRepository;
//import org.junit.jupiter.api.Assertions;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class MenuRepositoryTest {
    @Autowired private MenuRepository repo;

    @Test
    public void testAddMenu(){
        Menu menu=new Menu();
        menu.setNombre("Nombre menu prueba");
        menu.setPrecio(14.50F);

        Menu savedMenu = repo.save(menu);

        Assertions.assertThat(savedMenu).isNotNull();
        Assertions.assertThat(savedMenu.getIdmenu()).isGreaterThan(0);
    }
    @Test
    public void testListAll(){
        Iterable<Menu> menus = repo.findAll();
        Assertions.assertThat(menus).hasSizeGreaterThan(0);
        

        for (Menu menu : menus) {
            System.out.println(menu);
        }
    }
    @Test
    public void testUpdate(){
        Integer idmenu = 1;
        Optional<Menu> optionalMenu = repo.findById(idmenu);
        Menu menu = optionalMenu.get();
        menu.setNombre("Nombre editado");
        menu.setPrecio(13.50F);

        repo.save(menu);

        Menu updateMenu = repo.findById(idmenu).get();
        Assertions.assertThat(updateMenu.getNombre()).isEqualTo("Nombre editado");
    }

    @Test
    public void testGet(){
        Integer idmenu = 1;
        Optional<Menu> optionalMenu = repo.findById(idmenu);
        Assertions.assertThat(optionalMenu).isPresent();
        System.out.println(optionalMenu.get());

    }

    @Test
    public void testDelete(){
        Integer idmenu = 1;
        repo.deleteById(idmenu);

        Optional<Menu> optionalMenu = repo.findById(idmenu);
        Assertions.assertThat(optionalMenu).isNotPresent();
    }
}
