package com.lootzone.backend.controller;

import com.lootzone.backend.exception.ProductNotFoundException;
import com.lootzone.backend.model.Product;
import com.lootzone.backend.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{publicId}")
    public Product getProductById(@PathVariable String publicId) {
        return productService.getProductByPublicId(publicId)
                .orElseThrow(() -> new ProductNotFoundException(publicId));
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @PutMapping("/{publicId}")
    public Product updateProduct(@PathVariable String publicId, @RequestBody Product product) {
        return productService.updateProduct(publicId, product);
    }

    @DeleteMapping("/{publicId}")
    public void deleteProduct(@PathVariable String publicId) {
        productService.deleteProduct(publicId);
    }
}

