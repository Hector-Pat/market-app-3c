package com.tecdesoftware.market_app_3c.persistence.mapper;

import com.tecdesoftware.market_app_3c.domain.Product;
import com.tecdesoftware.market_app_3c.entity.Producto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = CategoryMapper.class)
public interface ProductMapper {

    @Mappings({
            @Mapping(source = "idProducto", target = "productId"),
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "precioVenta", target = "price"),
            @Mapping(source = "cantidadStock", target = "stock"),
            @Mapping(source = "estado", target = "active"),
            @Mapping(source = "categoria", target = "category")
    })
    Product toProduct(Producto producto);

    List<Product> toProducts(List<Producto> productos);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "codigoBarras", ignore = true),
            @Mapping(source = "categoryId", target = "idCategoria")
    })
    Producto toProducto(Product product);
}
