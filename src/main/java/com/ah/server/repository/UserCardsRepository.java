package com.ah.server.repository;

import com.ah.server.model.UserCards;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserCardsRepository extends JpaRepository<UserCards, UserCards.UserCardId> {
    List<UserCards> findByIdUserId(Long userId);
}
