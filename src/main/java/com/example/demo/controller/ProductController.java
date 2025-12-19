package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.impl.ProductServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@Tag(name = "Products")
public class ProductController {
    private final ProductServiceImpl productService;

    public ProductController(ProductRepository productRepository) {
        this.productService = new ProductServiceImpl(productRepository);
    }

    @PostMapping
    public Product create(@RequestBody Product p) { return productService.createProduct(p); }

    @PutMapping("/{id}")
    public Product update(@PathVariable Long id, @RequestBody Product p) { return productService.updateProduct(id, p); }

    @GetMapping("/{id}")
    public Product get(@PathVariable Long id) { return productService.getProductById(id); }

    @GetMapping
    public List<Product> list() { return productService.getAllProducts(); }

    @PutMapping("/{id}/deactivate")
    public void deactivate(@PathVariable Long id) { productService.deactivateProduct(id); }
}