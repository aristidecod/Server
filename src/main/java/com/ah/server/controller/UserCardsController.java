package com.ah.server.controller;

import com.ah.server.model.Card;
import com.ah.server.service.UserCardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserCardsController {

    private final UserCardsService userCardsService;

    @Autowired
    public UserCardsController(UserCardsService userCardsService) {
        this.userCardsService = userCardsService;
    }

    @GetMapping("/{userId}/cards")
    public ResponseEntity<List<Card>> getUserCards(@PathVariable Long userId) {
        List<Card> cards = userCardsService.findCardsByUserId(userId);
        return ResponseEntity.ok(cards);
    }
}

