

package com.ah.server.service;

import com.ah.server.model.Card;
import com.ah.server.model.User;
import com.ah.server.model.UserCards;
import com.ah.server.repository.UserCardsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
@ActiveProfiles("test")
public class UserCardsServiceTests {

    @Mock
    private UserCardsRepository userCardsRepository;

    @InjectMocks
    private UserCardsService userCardsService;

    @BeforeEach
    public void setUp() {
        // Configuration du mock
        User user = new User(); // Supposons que votre classe User ait un constructeur par défaut ou initialisez-le correctement
        user.setId(1L); // Assurez-vous de définir l'ID si votre entité l'exige

        Card card1 = new Card(); // Initialisez vos objets Card comme nécessaire
        card1.setId(1L);
        Card card2 = new Card();
        card2.setId(2L);

        UserCards userCard1 = new UserCards(user, card1, 5); // Supposons qu'il y ait un constructeur approprié
        UserCards userCard2 = new UserCards(user, card2, 3);

        List<UserCards> userCards = Arrays.asList(userCard1, userCard2);

        when(userCardsRepository.findByIdUserId(anyLong())).thenReturn(userCards);
    }

    @Test
    public void whenFindCardsByUserId_thenCardsShouldBeFound() {
        Long userId = 1L;
        List<Card> foundCards = userCardsService.findCardsByUserId(userId);

        assertThat(foundCards).isNotNull();
        assertThat(foundCards.size()).isEqualTo(2);
        assertThat(foundCards.get(0).getId()).isEqualTo(1L);
        assertThat(foundCards.get(1).getId()).isEqualTo(2L);
    }
}
