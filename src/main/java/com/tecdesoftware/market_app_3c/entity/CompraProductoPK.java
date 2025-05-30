package com.tecdesoftware.market_app_3c.entity;

//Para unir las 2 llaves y crear una llave compuesta
import jakarta.persistence.Embeddable;
import jakarta.persistence.Column;
import jakarta.persistence.Id;


import java.io.Serializable;

@Embeddable

public class CompraProductoPK implements Serializable {
    @Column(name="id_compra")
    private int idCompra;

    @Column (name="id_producto")
    private int idVendedor;
}
