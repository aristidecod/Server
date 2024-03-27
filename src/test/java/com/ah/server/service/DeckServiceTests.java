package com.ah.server.service;

import com.ah.server.model.Card;
import com.ah.server.model.Deck;
import com.ah.server.model.Rarete;
import com.ah.server.model.Type;
import com.ah.server.model.User;
import com.ah.server.repository.DeckRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")
public class DeckServiceTests {

    @Mock
    private DeckRepository deckRepository;

    @InjectMocks
    private DeckService deckService;

    private User user;
    private Deck mockDeck;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        // Initialize test user
        user = new User();
        user.setUsername("user1");
        user.setPasswordHash("pass123");

        // Initialize cards for the deck
        List<Card> mockCardsForDeck = Arrays.asList(
                new Card("Carte 3", "Desc 3", Rarete.LEGENDAIRE, Type.UNITE, 15, 25, 5),
                new Card("Carte 4", "Desc 4", Rarete.EPIQUE, Type.BATIMENT, 8, 35, 6)
        );

        // Initialize mock deck
        mockDeck = new Deck();
        mockDeck.setUser(user);
        mockDeck.setCards(mockCardsForDeck);
    }

    @Test
    void getDeckByUserIdTest() {
        given(deckRepository.findById(anyLong())).willReturn(Optional.of(mockDeck));

        Optional<Deck> foundDeck = deckService.findDeckById(1L);

        assertThat(foundDeck.isPresent()).isTrue();
        Deck deck = foundDeck.get();
        assertThat(deck.getCards()).hasSize(2);
        assertThat(deck.getUser().getUsername()).isEqualTo("user1");
        assertThat(deck.getCards().get(0).getNom()).isEqualTo("Carte 3");
        assertThat(deck.getCards().get(1).getNom()).isEqualTo("Carte 4");
    }
}
