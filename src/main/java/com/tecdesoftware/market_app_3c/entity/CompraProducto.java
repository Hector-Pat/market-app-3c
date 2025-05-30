package com.tecdesoftware.market_app_3c.entity;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.entity;
import jakarta.persistence.Table;

@Entity
@Table(name ="compras_productos")
public class CompraProducto {

    //ID PENDIENTE
    @EmbeddedId
    private CompraProductoPK id;

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

    private Integer cantidad;
    private Double compra;
    private Boolean estado;
}
