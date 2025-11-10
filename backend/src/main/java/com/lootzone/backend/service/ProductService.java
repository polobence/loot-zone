package com.lootzone.backend.service;

import com.lootzone.backend.dto.ProductRequest;
import com.lootzone.backend.dto.ProductResponse;
import com.lootzone.backend.exception.ProductNotFoundException;
import com.lootzone.backend.mapper.ProductMapper;
import com.lootzone.backend.model.Product;
import com.lootzone.backend.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(ProductMapper::toResponse)
                .collect(Collectors.toList());
    }

    public ProductResponse getProductByPublicId(String publicId) {
        Product product = productRepository.findByPublicId(publicId)
                .orElseThrow(() -> new ProductNotFoundException(publicId));
        return ProductMapper.toResponse(product);
    }

    public ProductResponse createProduct(ProductRequest request) {
        Product product = ProductMapper.toEntity(request);
        product.setPublicId(UUID.randomUUID().toString());
        Product saved = productRepository.save(product);
        return ProductMapper.toResponse(saved);
    }

    public ProductResponse updateProduct(String publicId, ProductRequest request) {
        Product existing = productRepository.findByPublicId(publicId)
                .orElseThrow(() -> new ProductNotFoundException(publicId));

        existing.setName(request.name());
        existing.setPrice(request.price());
        existing.setDescription(request.description());
        existing.setImageUrl(request.imageUrl());
        existing.setCategory(request.category());

        Product updated = productRepository.save(existing);
        return ProductMapper.toResponse(updated);
    }

    public void deleteProduct(String publicId) {
        Product existing = productRepository.findByPublicId(publicId)
                .orElseThrow(() -> new ProductNotFoundException(publicId));
        productRepository.delete(existing);
    }
}
