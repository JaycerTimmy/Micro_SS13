package com.microservice.product.controller;

import com.microservice.product.dto.ProductRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @GetMapping
    public ResponseEntity<List<String>> getProducts() {
        List<String> products = List.of("Product A", "Product B", "Product C");
        return ResponseEntity.ok(products);
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> createProduct(
            @RequestHeader("X-User-Role") String role,
            @RequestBody ProductRequest productRequest) {

        if ("ADMIN".equals(role)) {
            return ResponseEntity.ok(Map.of("message", "Product created successfully"));
        }

        return ResponseEntity.status(HttpStatus.FORBIDDEN)
                .body(Map.of("message", "Access denied. ADMIN role required."));
    }
}
