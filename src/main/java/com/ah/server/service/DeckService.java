package com.ah.server.service;

import com.ah.server.model.Deck;
import com.ah.server.repository.DeckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeckService {

    @Autowired
    private DeckRepository deckRepository;

    public List<Deck> findAllDecks() {
        return deckRepository.findAll();
    }

    public Optional<Deck> findDeckById(Long id) {
        return deckRepository.findById(id);
    }

    public Deck createDeck(Deck deck) {
        return deckRepository.save(deck);
    }

    public Deck updateDeck(Long id, Deck deckDetails) {
        Deck deck = deckRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Deck not found with id: " + id));
        deck.setUser(deckDetails.getUser());
        deck.setCards(deckDetails.getCards());
        return deckRepository.save(deck);
    }

    public void deleteDeck(Long id) {
        Deck deck = deckRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Deck not found with id: " + id));
        deckRepository.delete(deck);
    }
}
