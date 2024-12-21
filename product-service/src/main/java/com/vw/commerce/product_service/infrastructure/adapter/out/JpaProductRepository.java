package com.vw.commerce.product_service.infrastructure.adapter.out;

import com.vw.commerce.product_service.domain.model.Product;
import com.vw.commerce.product_service.domain.repository.ProductRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class JpaProductRepository implements ProductRepository {

    private final SpringDataProductRepository repository;

    public JpaProductRepository(SpringDataProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Product> findById(UUID id) {
        return repository.findById(id).map(ProductEntity::toDomain);
    }

    @Override
    public void save(Product product) {
        repository.save(new ProductEntity(product));
    }

    @Override
    public void deleteById(UUID id) {
        repository.deleteById(id);
    }
}

interface SpringDataProductRepository extends org.springframework.data.repository.Repository<ProductEntity, UUID> {
    Optional<ProductEntity> findById(UUID id);
    void deleteById(UUID id);
    ProductEntity save(ProductEntity productEntity);
}
