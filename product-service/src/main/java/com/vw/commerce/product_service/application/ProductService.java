package com.vw.commerce.product_service.application;

import com.vw.commerce.product_service.domain.model.Product;

import java.util.Optional;
import java.util.UUID;

public interface ProductService {
    Optional<Product> getProductById(UUID id);
    void createProduct(Product product);
    void deleteProduct(UUID id);
}
