package com.ah.server.controller;

import com.ah.server.model.Deck;
import com.ah.server.service.DeckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/decks")
public class DeckController {

    @Autowired
    private DeckService deckService;

    // Récupérer tous les decks
    @GetMapping
    public ResponseEntity<List<Deck>> getAllDecks() {
        List<Deck> decks = deckService.findAllDecks();
        return ResponseEntity.ok(decks);
    }

    // Récupérer un deck par son ID
    @GetMapping("/{id}")
    public ResponseEntity<Deck> getDeckById(@PathVariable Long id) {
        return deckService.findDeckById(id)
                .map(deck -> ResponseEntity.ok(deck))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Créer un nouveau deck
    @PostMapping
    public ResponseEntity<Deck> createDeck(@RequestBody Deck deck) {
        Deck newDeck = deckService.createDeck(deck);
        return ResponseEntity.ok(newDeck);
    }

    // Mettre à jour un deck
    @PutMapping("/{id}")
    public ResponseEntity<Deck> updateDeck(@PathVariable Long id, @RequestBody Deck deckDetails) {
        Deck updatedDeck = deckService.updateDeck(id, deckDetails);
        return ResponseEntity.ok(updatedDeck);
    }

    // Supprimer un deck
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDeck(@PathVariable Long id) {
        deckService.deleteDeck(id);
        return ResponseEntity.ok().build();
    }
}
