package com.ah.server.controller;

import com.ah.server.model.Card;
import com.ah.server.service.UserCardsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import java.util.Arrays;
import java.util.List;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class UserCardsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserCardsService userCardsService;

    @BeforeEach
    void setUp() {
        // Préparer des données de test
        Card card1 = new Card(); // Configurez votre objet Card comme nécessaire
        Card card2 = new Card();
        List<Card> testCards = Arrays.asList(card1, card2);

        given(userCardsService.findCardsByUserId(1L)).willReturn(testCards);
    }

    @Test
    @WithMockUser
    public void getUserCards_ShouldReturnCards() throws Exception {
        mockMvc.perform(get("/api/users/{userId}/cards", 1L)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2)); // Assurez-vous que cela correspond au nombre de cartes que vous avez mocké
    }
}
