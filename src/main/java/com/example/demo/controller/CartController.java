package com.example.demo.controller;

import com.example.demo.model.Cart;
import com.example.demo.repository.CartRepository;
import com.example.demo.service.impl.CartServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/carts")
@Tag(name = "Carts")
public class CartController {
    private final CartServiceImpl service;

    public CartController(CartRepository repo) {
        this.service = new CartServiceImpl(repo);
    }

    @PostMapping("/user/{userId}")
    public Cart create(@PathVariable Long userId) { return service.createCart(userId); }

    @GetMapping("/{id}")
    public Cart get(@PathVariable Long id) { return service.getCartById(id); }

    @GetMapping("/user/{userId}")
    public Cart getByUser(@PathVariable Long userId) { return service.getActiveCartForUser(userId); }

    @PutMapping("/{id}/deactivate")
    public void deactivate(@PathVariable Long id) { service.deactivateCart(id); }
}