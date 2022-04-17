package com.langosta.food.paracasa.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name="menus")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idmenu;

    @Column(length = 50, nullable = false)
    private String nombre;

    @Column
    private float precio;

    private boolean enabled;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @ManyToMany(cascade = {CascadeType.ALL},mappedBy = "menus")
    //@ManyToMany( fetch = FetchType.LAZY,cascade =CascadeType.PERSIST)
    //@JoinTable(name="ProductoMenu", joinColumns={@JoinColumn(name="idproducto")}, inverseJoinColumns={@JoinColumn(name="idmenu")})
    private Set<Producto> productos=new HashSet();

    public Integer getIdmenu() {
        return idmenu;
    }

    public void setIdmenu(Integer idmenu) {
        this.idmenu = idmenu;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public Set<Producto> getProductos() {
        return productos;
    }

    public void setProductos(Set<Producto> productos) {
        this.productos = productos;
    }

    public Menu() {

    }

    public Menu(Integer idmenu, String nombre, float precio, boolean enabled, Set<Producto> productos) {
        this.idmenu = idmenu;
        this.nombre = nombre;
        this.precio = precio;
        this.enabled = enabled;
        this.productos = productos;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "idmenu=" + idmenu +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", enabled=" + enabled +
                ", productos=" + productos +
                '}';
    }
}