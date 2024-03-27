package com.ah.server.controller;

import com.ah.server.model.Stats;
import com.ah.server.service.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/stats")
public class StatsController {

    private final StatsService statsService;

    @Autowired
    public StatsController(StatsService statsService) {
        this.statsService = statsService;
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<Stats> getStatsByUserId(@PathVariable Long userId) {
        // Utiliser findByUserId à la place de findStatsByUserId
        Optional<Stats> stats = statsService.findByUserId(userId);
        return stats.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
