package com.ah.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ah.server.model.Card;

import com.ah.server.model.Rarete;
import com.ah.server.model.Type;
import java.util.List;

public interface CardRepository extends JpaRepository<Card, Long> {
    List<Card> findByRarete(Rarete rarete);
    List<Card> findByType(Type rarete);
    //findByRarete pour trouver des cartes d'une rareté spécifique.
}

