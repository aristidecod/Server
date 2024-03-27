package com.ah.server.repository;

import com.ah.server.model.Card;
import com.ah.server.model.Rarete;
import com.ah.server.model.Type;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

@DataJpaTest
public class CardRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CardRepository cardRepository;

    @BeforeEach
    void setUp() {
        // Créez et persistez quelques cartes avec différents types
        Card attackCard = new Card();
        attackCard.setNom("Attack Card");
        attackCard.setCoutEnElixir(5);
        attackCard.setDegats(50);
        attackCard.setDescription("This is an attack card.");
        attackCard.setPointsDeVie(100);
        attackCard.setRarete(Rarete.COMMUNE); // ou une autre valeur appropriée
        attackCard.setType(Type.UNITE);
        entityManager.persist(attackCard);

        Card defenseCard = new Card();
        defenseCard.setNom("Defense Card");
        defenseCard.setCoutEnElixir(3);
        defenseCard.setDegats(30);
        defenseCard.setDescription("This is a defense card.");
        defenseCard.setPointsDeVie(150);
        defenseCard.setRarete(Rarete.RARE); // ou une autre valeur appropriée
        defenseCard.setType(Type.SORT);
        entityManager.persist(defenseCard);

        // Flush pour s'assurer que les données sont persistées avant le test
        entityManager.flush();
    }

    @Test
    void whenFindByType_thenReturnCardsWithThatType() {
        // Act
        List<Card> attackCards = cardRepository.findByType(Type.UNITE);

        // Assert
        Assertions.assertThat(attackCards).hasSize(1);
        Assertions.assertThat(attackCards.get(0).getType()).isEqualTo(Type.UNITE); // Correction ici, vérifiez si le type correspond au type recherché
    }
}
