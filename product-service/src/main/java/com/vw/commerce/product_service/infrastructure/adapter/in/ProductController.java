package com.vw.commerce.product_service.infrastructure.adapter.in;

import com.vw.commerce.product_service.application.ProductService;
import com.vw.commerce.product_service.domain.model.Product;
import com.vw.commerce.product_service.infrastructure.adapter.in.dto.ProductRequestDTO;
import com.vw.commerce.product_service.infrastructure.adapter.in.dto.ProductResponseDTO;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<String> createProduct(@RequestBody ProductRequestDTO productDTO) {
        var product = new Product();
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        productService.createProduct(product);
        return new ResponseEntity<>("Product created successfully!", HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> getProductById(@PathVariable UUID id) {
        var product = productService.getProductById(id).orElse(null);
        if (product == null) {
            return ResponseEntity.notFound().build();
        }
        var responseDTO = new ProductResponseDTO();
        responseDTO.setId(product.getId());
        responseDTO.setName(product.getName());
        responseDTO.setPrice(product.getPrice());
        return ResponseEntity.ok(responseDTO);
    }
}
