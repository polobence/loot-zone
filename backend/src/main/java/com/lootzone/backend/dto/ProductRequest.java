package com.lootzone.backend.dto;

public record ProductRequest(
        String name,
        Double price,
        String description,
        String imageUrl,
        String category
) {}
