package com.example.demo.entity;

import java.math.BigDecimal;
import java.security.Timestamp;
import jakarta.persistence.*;

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sku;
    private String name;
    private String category;
    private BigDecimal price;
    private Boolean active;
    private Timestamp createdAt;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getSku() {
        return sku;
    }
    public void setSku(String sku) {
        this.sku = sku;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    public Boolean getActive() {
        return active;
    }
    public void setActive(Boolean active) {
        this.active = active;
    }
    public Timestamp getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
    public Product(String sku, String name, String category, BigDecimal price, Boolean active,
            Timestamp createdAt) {
        this.sku = sku;
        this.name = name;
        this.category = category;
        this.price = price;
        this.active = active;
        this.createdAt = createdAt;
    }
    public Product() {
    }
}
