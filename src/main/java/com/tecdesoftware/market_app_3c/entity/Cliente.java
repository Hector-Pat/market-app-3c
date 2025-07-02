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
    private int id;
    private Integer nombre;
    private String apellido;
    //private Integer celular;
    private Long celular;
    private String direccion;
    private String email;
    @Column(name="correo_electronico")
    private String correoElectronico;

    // depende de compra
    @OneToMany(mappedBy = "cliente")
    private List<Compra> compras;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getNombre() {
        return nombre;
    }

    public void setNombre(Integer nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }
}
