package com.example.ecommerce.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;

import java.util.Set;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private double price;
    private int stock;

    @ManyToMany
    private Set<Category> categories;
}
