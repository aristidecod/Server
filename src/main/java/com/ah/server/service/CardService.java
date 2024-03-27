package com.ah.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ah.server.model.Card;
import com.ah.server.model.Rarete;
import com.ah.server.model.Type;
import com.ah.server.repository.CardRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CardService {

    @Autowired
    private CardRepository cardRepository;

    // Récupérer toutes les cartes
    public List<Card> getAllCards() {
        return cardRepository.findAll();
    }

    // Récupérer des cartes par rareté
    public List<Card> getCardsByRarete(Rarete rarete) {
        return cardRepository.findByRarete(rarete);
    }

    // Récupérer des cartes par type
    public List<Card> getCardsByType(Type type) {
        return cardRepository.findByType(type);
    }

    // Ajouter une nouvelle carte
    public Card addCard(Card card) {
        return cardRepository.save(card);
    }

    // Mettre à jour une carte
    public Card updateCard(Long cardId, Card cardDetails) {
        Card card = cardRepository.findById(cardId)
                .orElseThrow(() -> new NoSuchElementException("Card not found with id: " + cardId));

        card.setNom(cardDetails.getNom());
        card.setDescription(cardDetails.getDescription());
        card.setRarete(cardDetails.getRarete());
        card.setType(cardDetails.getType());
        card.setDegats(cardDetails.getDegats());
        card.setPointsDeVie(cardDetails.getPointsDeVie());
        card.setCoutEnElixir(cardDetails.getCoutEnElixir());

        return cardRepository.save(card);
    }

    // Supprimer une carte
    public void deleteCard(Long cardId) {
        cardRepository.deleteById(cardId);
    }
}

