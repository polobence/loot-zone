package com.lootzone.backend.repository;

import com.lootzone.backend.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByPublicId(String publicId);
    void deleteByPublicId(String publicId);
}
