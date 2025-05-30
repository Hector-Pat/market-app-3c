package com.tecdesoftware.market_app_3c.entity;
import com.fasterxml.jackson.annotation.JsonTypeId;
import jakarta.persistence.*;
import jakarta.persistence.Column;
@Entity
@Table(name="productos")
public class Producto {
    @Id//ES LA LLAVE PRIMARIA
    //Auto genera ids utoincrementables
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="id_Producto")
    private int idProducto;
    private String nombre;

    @Column(name = "id_categoria")
    private Integer idCategoria;

    @Column(name="codigo_barras")
    private String codigoBarras;

    @Column(name="precio_venta")
    private Double precioVenta;

    @Column(name="cantidad_stocks")
    private Integer cantidadStocks;
    private Boolean estado;

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Integer getCantidadStocks() {
        return cantidadStocks;
    }

    public void setCantidadStocks(Integer cantidadStocks) {
        this.cantidadStocks = cantidadStocks;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}

