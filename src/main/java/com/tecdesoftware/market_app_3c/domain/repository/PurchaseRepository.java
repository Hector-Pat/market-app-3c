package com.tecdesoftware.market_app_3c.domain.repository;

import com.tecdesoftware.market_app_3c.domain.Purchase;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepository {
    List<Purchase> getAll();
    Optional<List<Purchase>> getByClient(String clientId);
    Purchase save(Purchase purchase);
}
