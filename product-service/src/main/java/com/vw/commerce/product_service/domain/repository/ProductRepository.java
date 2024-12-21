package com.vw.commerce.product_service.domain.repository;

import com.vw.commerce.product_service.domain.model.Product;

import java.util.Optional;
import java.util.UUID;

public interface ProductRepository {
    Optional<Product> findById(UUID id);
    void save(Product product);
    void deleteById(UUID id);
}
