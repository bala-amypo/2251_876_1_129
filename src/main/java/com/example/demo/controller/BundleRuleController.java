package com.example.demo.controller;

import com.example.demo.model.BundleRule;
import com.example.demo.repository.BundleRuleRepository;
import com.example.demo.service.impl.BundleRuleServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bundle-rules")
@Tag(name = "Bundle Rules")
public class BundleRuleController {
    private final BundleRuleServiceImpl service;

    public BundleRuleController(BundleRuleRepository repo) {
        this.service = new BundleRuleServiceImpl(repo);
    }

    @PostMapping
    public BundleRule create(@RequestBody BundleRule r) { return service.createRule(r); }

    @PutMapping("/{id}")
    public BundleRule update(@PathVariable Long id, @RequestBody BundleRule r) { return service.updateRule(id, r); }

    @GetMapping("/{id}")
    public BundleRule get(@PathVariable Long id) { return service.getRuleById(id); }

    @GetMapping("/active")
    public List<BundleRule> active() { return service.getActiveRules(); }

    @PutMapping("/{id}/deactivate")
    public void deactivate(@PathVariable Long id) { service.deactivateRule(id); }
}