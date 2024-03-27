package com.ah.server.service;

import com.ah.server.model.Card;
import com.ah.server.model.Rarete;
import com.ah.server.model.Type;
import com.ah.server.repository.CardRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")
public class CardServiceTest {

    @Mock
    private CardRepository cardRepository;

    @InjectMocks
    private CardService cardService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllCardsTest() {
        List<Card> mockCards = Arrays.asList(
                new Card("Carte 1", "Desc 1", Rarete.EPIQUE, Type.UNITE, 10, 20, 3),
                new Card("Carte 2", "Desc 2", Rarete.RARE, Type.SORT, 5, 30, 4)
        );

        given(cardRepository.findAll()).willReturn(mockCards);

        List<Card> cards = cardService.getAllCards();

        assertThat(cards).hasSize(2);
        assertThat(cards.get(0).getNom()).isEqualTo("Carte 1");
        assertThat(cards.get(1).getType()).isEqualTo(Type.SORT);
    }
}
