package com.langosta.food.paracasa.model;

import org.springframework.data.repository.CrudRepository;

public interface MenuRepository extends CrudRepository<Menu,Integer> {

    //public Long countById(Integer id);
}
