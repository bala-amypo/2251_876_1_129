package com.example.demo.model;

import java.math.BigDecimal;
import java.security.Timestamp;
import jakarta.persistence.*;

@Entity
public class DiscountApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private ManyToOne cart;
    private ManyToOne bundleRule;
    private BigDecimal discountAmount;
    private Timestamp appliedAt;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public ManyToOne getCart() {
        return cart;
    }
    public void setCart(ManyToOne cart) {
        this.cart = cart;
    }
    public ManyToOne getBundleRule() {
        return bundleRule;
    }
    public void setBundleRule(ManyToOne bundleRule) {
        this.bundleRule = bundleRule;
    }
    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }
    public void setDiscountAmount(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
    }
    public Timestamp getAppliedAt() {
        return appliedAt;
    }
    public void setAppliedAt(Timestamp appliedAt) {
        this.appliedAt = appliedAt;
    }
    public DiscountApplication(ManyToOne cart, ManyToOne bundleRule, BigDecimal discountAmount, Timestamp appliedAt) {
        this.cart = cart;
        this.bundleRule = bundleRule;
        this.discountAmount = discountAmount;
        this.appliedAt = appliedAt;
    }
    public DiscountApplication() {
    } 
}
