package com.tecdesoftware.market_app_3c.entity;

import com.fasterxml.jackson.annotation.JsonTypeId;
import jakarta.persistence.*;
import jakarta.persistence.Column;
import java.time.LocalDateTime;
import java.util.List;
@Entity
@Table(name="Clientes")
public class Cliente {

    @Id//ES LA LLAVE PRIMARIA
    //Auto genera ids utoincrementables
    //@GeneratedValue no va porque el ID será la CURP
    @Column(name = "id")
    private String id;
    private String nombre;
    private String apellidos;
    //private Integer celular;
    private Long celular;
    private String direccion;

    @Column(name="correo_electronico")
    private String correoElectronico;

    // depende de compra
    @OneToMany(mappedBy = "cliente")
    private List<Compra> compras;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellido(String apellido) {
        this.apellidos = apellido;
    }

    public Long getCelular() {
        return celular;
    }

    public void setCelular(Long celular) {
        this.celular = celular;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }



    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }
}
