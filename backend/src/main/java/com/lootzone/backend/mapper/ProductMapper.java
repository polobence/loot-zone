package com.lootzone.backend.mapper;

import com.lootzone.backend.dto.ProductRequest;
import com.lootzone.backend.dto.ProductResponse;
import com.lootzone.backend.model.Product;

public class ProductMapper {

    public static ProductResponse toResponse(Product p) {
        return new ProductResponse(
                p.getPublicId(),
                p.getName(),
                p.getPrice(),
                p.getDescription(),
                p.getImageUrl(),
                p.getCategory()
        );
    }

    public static Product toEntity(ProductRequest req) {
        Product p = new Product();
        p.setName(req.name());
        p.setPrice(req.price());
        p.setDescription(req.description());
        p.setImageUrl(req.imageUrl());
        p.setCategory(req.category());
        return p;
    }
}
