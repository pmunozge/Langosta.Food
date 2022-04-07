package com.langosta.food.paracasa.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="tipo")
public class Tipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idtipo;

    @Column(length = 50, nullable = false)
    private String nombre;

    @OneToMany(mappedBy = "tipo", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Producto> producto;

    public Integer getIdtipo() {
        return idtipo;
    }

    public void setIdtipo(Integer idtipo) {
        this.idtipo = idtipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }



    public Tipo() {
    }

    public Tipo(Integer idtipo, String nombre, Producto producto) {
        this.idtipo = idtipo;
        this.nombre = nombre;
        //this.producto = producto;
    }

    public Set<Producto> getProducto() {
        return producto;
    }

    public void setProducto(Set<Producto> producto) {
        this.producto = producto;
    }
}
