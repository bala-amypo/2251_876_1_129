package com.example.demo.model;

import jakarta.persistence.*;

public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private ManyToOne cart;
    private ManyToOne product;
    private Integer quantity;
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
    public ManyToOne getProduct() {
        return product;
    }
    public void setProduct(ManyToOne product) {
        this.product = product;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    public CartItem(ManyToOne cart, ManyToOne product, Integer quantity) {
        this.cart = cart;
        this.product = product;
        this.quantity = quantity;
    }
    public CartItem() {
    }
}
