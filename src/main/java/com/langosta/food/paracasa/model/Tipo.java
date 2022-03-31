package com.langosta.food.paracasa.model;

import javax.persistence.*;
@Entity
@Table(name="tipo")
public class Tipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idtipo;

    @Column(length = 50, nullable = false)
    private String nombre;

    @OneToOne(mappedBy = "tipo", cascade = CascadeType.ALL)
    private Producto producto;

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

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Tipo() {
    }

    public Tipo(Integer idtipo, String nombre, Producto producto) {
        this.idtipo = idtipo;
        this.nombre = nombre;
        this.producto = producto;
    }
}
