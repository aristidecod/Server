package com.ah.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.ah.server.service.CardService;
import com.ah.server.model.Card;
import com.ah.server.model.Rarete;
import com.ah.server.model.Type;

import java.util.List;

@RestController
@RequestMapping("/api/cards")
public class CardController {

    @Autowired
    private CardService cardService;

    // Récupérer toutes les cartes
    @GetMapping
    public ResponseEntity<List<Card>> getAllCards() {
        List<Card> cards = cardService.getAllCards();
        return ResponseEntity.ok(cards);
    }

    // Récupérer des cartes par rareté
    @GetMapping("/rarete/{rarete}")
    public ResponseEntity<List<Card>> getCardsByRarete(@PathVariable Rarete rarete) {
        List<Card> cards = cardService.getCardsByRarete(rarete);
        return ResponseEntity.ok(cards);
    }

    // Récupérer des cartes par type
    @GetMapping("/type/{type}")
    public ResponseEntity<List<Card>> getCardsByType(@PathVariable Type type) {
        List<Card> cards = cardService.getCardsByType(type);
        return ResponseEntity.ok(cards);
    }

    // Ajouter une nouvelle carte
    @PostMapping
    public ResponseEntity<Card> addCard(@RequestBody Card card) {
        Card newCard = cardService.addCard(card);
        return ResponseEntity.ok(newCard);
    }

    // Mettre à jour une carte
    @PutMapping("/{id}")
    public ResponseEntity<Card> updateCard(@PathVariable Long id, @RequestBody Card cardDetails) {
        Card updatedCard = cardService.updateCard(id, cardDetails);
        return ResponseEntity.ok(updatedCard);
    }

    // Supprimer une carte
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCard(@PathVariable Long id) {
        cardService.deleteCard(id);
        return ResponseEntity.ok().build();
    }
}

