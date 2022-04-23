package com.langosta.food.paracasa.model;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name="pedidos")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idpedido;

    @Column
    private Date fecha;

    public Pedido(Integer idpedido, Date fecha) {
        this.idpedido = idpedido;
        this.fecha = fecha;
    }


    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name="PedidoMenu", joinColumns={@JoinColumn(name="idpedido")}, inverseJoinColumns={@JoinColumn(name="idmenu")})
    private Set<Menu> menus=new HashSet();






    public Pedido() {
    }

    public Integer getIdpedido() {
        return idpedido;
    }

    public void setIdpedido(Integer idpedido) {
        this.idpedido = idpedido;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
