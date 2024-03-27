package com.ah.server.service;

import com.ah.server.model.Stats;
import com.ah.server.repository.StatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StatsService {

    private final StatsRepository statsRepository;

    @Autowired
    public StatsService(StatsRepository statsRepository) {
        this.statsRepository = statsRepository;
    }

    public Optional<Stats> findByUserId(Long userId) {
        return statsRepository.findByUserId(userId);
    }
}

