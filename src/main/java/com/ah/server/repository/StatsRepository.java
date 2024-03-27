package com.ah.server.repository;

import com.ah.server.model.Stats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface StatsRepository extends JpaRepository<Stats, Long> {
    // Méthode pour trouver les statistiques par userId
    Optional<Stats> findByUserId(Long userId);
}
