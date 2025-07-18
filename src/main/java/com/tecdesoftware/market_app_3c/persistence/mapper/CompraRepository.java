package com.tecdesoftware.market_app_3c.persistence.mapper;

import com.tecdesoftware.market_app_3c.domain.Purchase;
import com.tecdesoftware.market_app_3c.domain.repository.PurchaseRepository;
import com.tecdesoftware.market_app_3c.entity.Compra;
import com.tecdesoftware.market_app_3c.persistence.crud.CompraCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CompraRepository implements PurchaseRepository {


    @Autowired
    private CompraCrudRepository compraCrudRepository;

    @Autowired
    private PurchaseMappper mapper;

    @Override
    public List<Purchase> getAll() {
        return mapper.toPurchases((List<Compra>) compraCrudRepository.findAll());
    }

    @Override
    public Optional<List<Purchase>> getByClient(String clientId) {
        return compraCrudRepository.findByIdCliente(clientId).map(compra -> mapper.toPurchases((List<Compra>) compra));
    }

    @Override
    public Purchase save(Purchase purchase) {
        Compra compra = mapper.toCompra(purchase);
        compra.getProductos().forEach(producto -> producto.setCompra(compra));
        return mapper.toPurchase(compraCrudRepository.save(compra));
    }
}