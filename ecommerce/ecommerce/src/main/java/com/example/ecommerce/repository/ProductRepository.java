package com.example.ecommerce.repository;


import com.example.ecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByCategories_Name(String categoryName); // 1

    @Query("SELECT p FROM Product p WHERE p.stock < :qty")
    List<Product> lowStock(@Param("qty") int qty); // 2

    @Query("SELECT p FROM Product p WHERE p.id NOT IN (SELECT oi.product.id FROM OrderItem oi)")
    List<Product> neverOrdered(); // 3
}

