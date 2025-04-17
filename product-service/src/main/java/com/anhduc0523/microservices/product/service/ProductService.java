package com.anhduc0523.microservices.product.service;

import com.anhduc0523.microservices.product.dto.ProductRequest;
import com.anhduc0523.microservices.product.dto.ProductResponse;
import com.anhduc0523.microservices.product.model.Product;
import com.anhduc0523.microservices.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;

    public List<ProductResponse> index(String name) {
        List<ProductResponse> products = productRepository.findAllByNameLike(name)
                .stream()
                .map(ProductResponse::fromProduct)
                .toList();
        log.info("Retrieved {} products successfully", products.size());

        return products;
    }

    public ProductResponse create(ProductRequest productRequest) {
        Product product = productRepository.save(
                Product.builder()
                .name(productRequest.name())
                .description(productRequest.description())
                .price(productRequest.price())
                        .build()
        );
        log.info("Product created successfully: {}", product);

        return ProductResponse.fromProduct(product);
    }

    public ProductResponse show(String id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        log.info("Product retrieved successfully: {}", product);

        return ProductResponse.fromProduct(product);
    }

    public ProductResponse update(String id, ProductRequest productRequest) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        product.setName(productRequest.name());
        product.setDescription(productRequest.description());
        product.setPrice(productRequest.price());

        Product updatedProduct = productRepository.save(product);
        log.info("Product updated successfully: {}", updatedProduct);

        return ProductResponse.fromProduct(updatedProduct);
    }

    public void delete(String id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        productRepository.delete(product);
        log.info("Product {} deleted successfully: ", id);
    }
}
