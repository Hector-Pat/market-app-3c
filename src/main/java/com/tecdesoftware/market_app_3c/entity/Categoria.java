

package com.tecdesoftware.market_app_3c.entity;
import jakarta.persistence.*;
        import org.springframework.data.annotation.Id;

import java.util.List;

@Entity
@Table(name = "categorias")

public class Categoria{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categorias")

    private Integer  idCategoria;
    private String descripcion;
    private  Boolean estado;

    @OneToMany(mappedBy = "categoria")
    private List<Producto> productos;
    @jakarta.persistence.Id
    private Long id;

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

}