package com.microservice.identity.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @GetMapping
    public ResponseEntity<List<String>> getProducts() {
        List<String> products = List.of(
                "Laptop Dell XPS 15",
                "iPhone 15 Pro Max",
                "Samsung Galaxy S24 Ultra",
                "MacBook Pro M3",
                "Sony WH-1000XM5"
        );
        return ResponseEntity.ok(products);
    }
}
