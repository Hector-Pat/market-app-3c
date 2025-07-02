package com.tecdesoftware.market_app_3c.persistence;

import com.tecdesoftware.market_app_3c.persistence.crud.ProductoCrudRepository;
import com.tecdesoftware.market_app_3c.entity.Producto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
//Le dice a spring este archivo se enlaza con la Base de Datos "decorador"
@Repository
public class ProductoRepository {

    private ProductoCrudRepository productoCrudRepository;

    public List<Producto> getAll() {
        return (List<Producto>) productoCrudRepository.findAll();
    }

    public List<Producto> getByCategoria(int idCategoria) {
        return productoCrudRepository.findByIdCategoriaOrderByNombreASC(idCategoria);
    }

    public Optional<List<Producto>> getEscasos(int cantidad) {
        return productoCrudRepository.findByCantidadStockLessThanAndEstado(cantidad, true);
    }
    //Guardar un producto
    public Producto save(Producto producto){
        return productoCrudRepository.save(producto);
    }
    
}