package com.example.demo.controller;

import com.example.demo.model.DiscountApplication;
import com.example.demo.repository.BundleRuleRepository;
import com.example.demo.repository.CartItemRepository;
import com.example.demo.repository.CartRepository;
import com.example.demo.repository.DiscountApplicationRepository;
import com.example.demo.service.impl.DiscountServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/discounts")
@Tag(name = "Discounts")
public class DiscountController {
    private final DiscountServiceImpl service;

    public DiscountController(DiscountApplicationRepository dar, BundleRuleRepository brr, CartRepository cr, CartItemRepository cir) {
        this.service = new DiscountServiceImpl(dar, brr, cr, cir);
    }

    @PostMapping("/evaluate/{cartId}")
    public List<DiscountApplication> evaluate(@PathVariable Long cartId) { return service.evaluateDiscounts(cartId); }

    @GetMapping("/{id}")
    public DiscountApplication get(@PathVariable Long id) { return service.getApplicationById(id); }

    @GetMapping("/cart/{cartId}")
    public List<DiscountApplication> list(@PathVariable Long cartId) { return service.getApplicationsForCart(cartId); }
}