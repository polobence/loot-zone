package com.lootzone.backend.exception;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String publicId) {
        super("Product not found with id: " + publicId);
    }
}
