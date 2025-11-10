package com.lootzone.backend.controller;

import com.lootzone.backend.dto.ProductRequest;
import com.lootzone.backend.dto.ProductResponse;
import com.lootzone.backend.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<ProductResponse> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{publicId}")
    public ProductResponse getProductByPublicId(@PathVariable String publicId) {
        return productService.getProductByPublicId(publicId);
    }

    @PostMapping
    public ProductResponse createProduct(@RequestBody ProductRequest request) {
        return productService.createProduct(request);
    }

    @PutMapping("/{publicId}")
    public ProductResponse updateProduct(@PathVariable String publicId, @RequestBody ProductRequest request) {
        return productService.updateProduct(publicId, request);
    }

    @DeleteMapping("/{publicId}")
    public void deleteProduct(@PathVariable String publicId) {
        productService.deleteProduct(publicId);
    }

}
