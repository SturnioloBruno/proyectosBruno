package com.example.fixture.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @GetMapping("/")
    public ResponseEntity<String> home() {
        return ResponseEntity.ok("<h1> Ingresaste al sistema </h1>");
    }
}
