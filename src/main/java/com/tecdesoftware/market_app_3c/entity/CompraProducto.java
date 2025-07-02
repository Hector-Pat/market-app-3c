package com.tecdesoftware.market_app_3c.entity;
import jakarta.persistence.*;
import jakarta.persistence.Entity;

@Entity
@Table(name ="compras_productos")
public class CompraProducto {

    //ID PENDIENTE
    @EmbeddedId
    private CompraProductoPK id;
    private Integer cantidad;
    private Double compra;
    private Boolean estado;

    //Saber todos los productos que hay en la compra
    @ManyToOne
    @JoinColumn(name= "id_compra", insertable = false, updatable = false)
    private Compra compras;
    @ManyToOne
    @JoinColumn(name= "id_producto", insertable = false, updatable = false)
    private Producto producto;

    public CompraProductoPK getId() {
        return id;
    }

    public void setId(CompraProductoPK id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getCompra() {
        return compra;
    }

    public void setCompra(Double compra) {
        this.compra = compra;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }


}
