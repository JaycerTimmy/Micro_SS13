package com.microservice.identity.controller;

import com.microservice.identity.dto.LoginRequest;
import com.microservice.identity.dto.RegisterRequest;
import com.microservice.identity.dto.UserResponse;
import com.microservice.identity.entity.User;
import com.microservice.identity.service.AuthService;
import com.microservice.identity.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final JwtUtil jwtUtil;

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@RequestBody RegisterRequest request) {
        UserResponse response = authService.register(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request) {
        String token = authService.login(request);
        return ResponseEntity.ok(token);
    }

    @GetMapping("/test-token")
    public ResponseEntity<String> testToken(@RequestParam String username) {
        User user = authService.getUserByUsername(username);
        String token = jwtUtil.generateToken(user);
        return ResponseEntity.ok(token);
    }
}
