    package com.example.demo.model;

    import jakarta.persistence.*;
    import java.math.BigDecimal;
    import java.time.LocalDateTime;

    @Entity
    public class Product {
        
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        
        @Column(unique = true, nullable = false)
        private String sku;
        
        @Column(nullable = false)
        private String name;
        
        private String category;
        
        @Column(nullable = false)
        private BigDecimal price;
        
        @Column(nullable = false)
        private Boolean active = true;
        
        @Column(name = "created_at")
        private LocalDateTime createdAt;
        
        @PrePersist
        protected void onCreate() {
            createdAt = LocalDateTime.now();
        }
        
        public Product() {}
        
        public Product(String sku, String name, BigDecimal price) {
            this.sku = sku;
            this.name = name;
            this.price = price;
            this.active = true;
        }
        
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
        
        public LocalDateTime getCreatedAt() {
            return createdAt;
        }
        
        public void setCreatedAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
        }
    }
