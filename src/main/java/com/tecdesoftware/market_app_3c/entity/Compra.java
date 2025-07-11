package com.tecdesoftware.market_app_3c.entity;
import com.fasterxml.jackson.annotation.JsonTypeId;
import jakarta.persistence.*;
import jakarta.persistence.Column;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name="compras")
public class Compra {
    @Id//ES LA LLAVE PRIMARIA
    //Auto genera ids utoincrementables
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_compra")
    private int idCompra;
    private String nombre;

    @Column(name = "id_cliente")
    private String idCliente;

    private LocalDateTime fecha;

    @Column(name = "medio_pago")
    private String medioPago;

    private Integer comentario;

    private Boolean estado;


    //Relación con cliente; muchas compras para un cliente

    @OneToMany(mappedBy = "compra")
    private List<CompraProducto> productos;

    public List<CompraProducto> getProductos() {
        return productos;
    }

    public void setProductos(List<CompraProducto> productos) {
        this.productos = productos;
    }

    //Insertable/Updatable en false es para que no haya modificaciones, solo relacionarlas
    @JoinColumn(name = "id_cliente", insertable = false, updatable = false)


    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getMedioPago() {
        return medioPago;
    }

    public void setMedioPago(String medioPago) {
        this.medioPago = medioPago;
    }

    public Integer getComentario() {
        return comentario;
    }

    public void setComentario(Integer comentario) {
        this.comentario = comentario;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }


}