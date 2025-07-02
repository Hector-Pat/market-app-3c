package com.tecdesoftware.market_app_3c.persistence.crud;
import com.tecdesoftware.market_app_3c.entity.Producto;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepository extends CrudRepository<Producto, Long> {

    //Query methods
    /*
    Select *
    From Categorias
    Where id_categorias = ?
    Order By Nombre ASC
     */


    //Obtener una lista de productos filtrados por id de categoria y ordenados por ascendentemente por nombre
    List<Producto> findByIdCategoriaOrderByNombreASC(int idCategoria);

    //Obtener los productos escasos
    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidad, boolean estado);



}