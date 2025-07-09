package com.tecdesoftware.market_app_3c.domain.service;

import com.tecdesoftware.market_app_3c.domain.Product;
import com.tecdesoftware.market_app_3c.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll() {
        return productRepository.getAll();
    }

    public Optional<Product> getProduct(int productId){
        return productRepository.getProduct(productId);
    }

    public Optional<List<Product>> getByCategory(int categoryId){
        return productRepository.getByCategory(categoryId);
    }
    public Product save(Product product) {
        return productRepository.save(product);
    }
    public Boolean delete(int productId) {
        //veirificar un IF que si el producto que se dessea eliminar
        if (getProduct(productId).isPresent()) {
            productRepository.delete(productId);
            return true;
        } else{
            return false;
        }
    }
}
