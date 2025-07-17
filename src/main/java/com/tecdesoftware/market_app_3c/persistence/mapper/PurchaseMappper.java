package com.tecdesoftware.market_app_3c.persistence.mapper;


import com.tecdesoftware.market_app_3c.domain.Purchase;
import com.tecdesoftware.market_app_3c.entity.Compra;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel ="spring", uses = {PurchaseItemMapper.class})

public interface PurchaseMappper {

    @Mappings({
            @Mapping(source = "idCompra", target = "purchaseId"),
            @Mapping(source = "idCliente", target = "clientId"),
            @Mapping(source = "fecha", target = "date"),
            @Mapping(source = "medioPago", target = "paymentMethod"),
            @Mapping(source = "comentario", target = "comment"),
            @Mapping(source = "estado", target = "state"),
            @Mapping(source = "productos", target = "items")

    })

    Purchase toPurchase(Compra compra);
    //convierte una lista de compras en una lisgta de purchases y usa los mismos Mappings
    List<Purchase> toPurchases(List<Compra> compras);

    //hacer la inversa:
    @InheritInverseConfiguration
    @Mapping(target = "idCliente", ignore = true)
    Compra toCompra(Purchase purchase);
}

