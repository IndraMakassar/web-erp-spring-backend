package com.example.weberpspringbackend.controller;

import com.example.weberpspringbackend.config.AuthService;
import com.example.weberpspringbackend.model.AuthenticationRequest;
import com.example.weberpspringbackend.model.AuthenticationResponse;
import com.example.weberpspringbackend.model.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @GetMapping
    public HttpStatus checkAuth() {
        return HttpStatus.OK;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> addUser(@RequestBody RegisterRequest user) {
        return ResponseEntity.ok(authService.register(user));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(authService.authenticate(request));
    }
}
