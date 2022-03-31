package com.langosta.food.paracasa.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idproducto;

    @Column(length = 50, nullable = false)
    private String nombre;

    @Column(length = 250, nullable = false)
    private String descripcion;

    @Column
    private String kcal;

    @OneToOne
    @JoinColumn(name = "FK_TIPO", updatable = false, nullable = false)
    private Tipo tipo;


    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name="ProductoMenu", joinColumns={@JoinColumn(name="idproducto")}, inverseJoinColumns={@JoinColumn(name="idmenu")})
    private Set<Menu> menus=new HashSet();


    public Integer getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(Integer idproducto) {
        this.idproducto = idproducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getKcal() {
        return kcal;
    }

    public void setKcal(String kcal) {
        this.kcal = kcal;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Set<Menu> getMenus() {
        return menus;
    }

    public void setMenus(Set<Menu> menus) {
        this.menus = menus;
    }

    public Producto() {
    }

    public Producto(Integer idproducto, String nombre, String descripcion, String kcal, Tipo tipo, Set<Menu> menus) {
        this.idproducto = idproducto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.kcal = kcal;
        this.tipo = tipo;
        this.menus = menus;
    }
}
