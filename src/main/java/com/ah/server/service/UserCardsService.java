package com.ah.server.service;

import com.ah.server.model.Card;
import com.ah.server.model.UserCards;
import com.ah.server.repository.UserCardsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserCardsService {

    private final UserCardsRepository userCardsRepository;

    public UserCardsService(UserCardsRepository userCardsRepository) {
        this.userCardsRepository = userCardsRepository;
    }

    public List<Card> findCardsByUserId(Long userId) {
        return userCardsRepository.findByIdUserId(userId).stream()
                .map(UserCards::getCard)
                .collect(Collectors.toList());
    }
}
