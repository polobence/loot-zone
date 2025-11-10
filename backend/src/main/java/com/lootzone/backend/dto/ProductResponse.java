package com.lootzone.backend.dto;

public record ProductResponse(
        String publicId,
        String name,
        Double price,
        String description,
        String imageUrl,
        String category
) {}
