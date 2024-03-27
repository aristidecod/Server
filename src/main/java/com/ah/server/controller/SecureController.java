package com.ah.server.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecureController {
    @GetMapping("/api/secure")
    public ResponseEntity<String> getSecureMessage() {
        return ResponseEntity.ok("Accès sécurisé réussi");
    }
}

