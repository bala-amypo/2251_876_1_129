package com.example.demo.service.impl;

import com.example.demo.model.Cart;
import com.example.demo.repository.CartRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CartServiceImpl {
    
    private final CartRepository cartRepository;
    
    public CartServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }
    
    @Transactional
    public Cart createCart(Long userId) {
        // Check if user already has an active cart
        Optional<Cart> existingCart = cartRepository.findByUserIdAndActiveTrue(userId);
        if (existingCart.isPresent()) {
            throw new IllegalArgumentException("Cart already exists for this user");
        }
        
        Cart cart = new Cart(userId);
        return cartRepository.save(cart);
    }
    
    public Cart getActiveCartForUser(Long userId) {
        return cartRepository.findByUserIdAndActiveTrue(userId)
                .orElseThrow(() -> new EntityNotFoundException("Active cart not found for user"));
    }
    
    public Cart getCartById(Long id) {
        return cartRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cart not found"));
    }
    
    @Transactional
    public void deactivateCart(Long id) {
        Cart cart = cartRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cart not found"));
        cart.setActive(false);
        cartRepository.save(cart);
    }
}