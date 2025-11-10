package com.lootzone.backend.service;

import com.lootzone.backend.model.Product;
import com.lootzone.backend.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductByPublicId(String publicId) {
        return productRepository.findByPublicId(publicId);
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(String publicId, Product updatedProduct) {
        Product existing = productRepository.findByPublicId(publicId)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        existing.setName(updatedProduct.getName());
        existing.setPrice(updatedProduct.getPrice());
        existing.setDescription(updatedProduct.getDescription());
        existing.setImageUrl(updatedProduct.getImageUrl());
        existing.setCategory(updatedProduct.getCategory());
        return productRepository.save(existing);
    }

    public void deleteProduct(String publicId) {
        productRepository.deleteByPublicId(publicId);
    }
}
