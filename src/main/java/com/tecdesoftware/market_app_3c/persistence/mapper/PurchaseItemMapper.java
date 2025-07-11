package com.tecdesoftware.market_app_3c.persistence.mapper;
import com.tecdesoftware.market_app_3c.entity.CompraProducto;
import com.tecdesoftware.market_app_3c.entity.CompraProductoPK;
import com.tecdesoftware.market_app_3c.domain.Purchaseitem;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;


@Mapper (componentModel = "spring")
public interface PurchaseItemMapper {

        @Mappings({
                @Mapping(source = "id.idProducto", target = "productId"),
                @Mapping(source = "cantidad", target = "quantity"),
                @Mapping(source = "estado", target = "active")
        })

        Purchaseitem toPurchaseItem(CompraProducto producto);

    @InheritInverseConfiguration
    //decirle que ignore los 3:
    @Mappings({
            @Mapping(target = "id.idCompra", ignore = true),
            @Mapping(target = "compra", ignore = true),
            @Mapping(target = "id.idProducto", ignore = true),
    })
    CompraProducto toCompraProducto(Purchaseitem item);
}


