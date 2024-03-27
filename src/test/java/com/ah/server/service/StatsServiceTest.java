package com.ah.server.service;

import com.ah.server.model.Stats;
import com.ah.server.repository.StatsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")
public class StatsServiceTest {

    @MockBean
    private StatsRepository statsRepository;

    @Autowired
    private StatsService statsService; // Utilisez @Autowired au lieu de @InjectMocks

    @BeforeEach
    public void setUp() {
        // Configuration de mock : lorsque findByUserId est appelé avec n'importe quel Long, retourne un Optional de Stats spécifique
        Long userId = 1L;
        Stats expectedStats = new Stats(200, 10, 100, 50, userId);
        when(statsRepository.findByUserId(userId)).thenReturn(Optional.of(expectedStats));
    }

    @Test
    public void whenFindByUserId_thenStatsShouldBeFound() {
        Long userId = 1L;
        Optional<Stats> foundStats = statsService.findByUserId(userId);

        assertThat(foundStats.isPresent()).isTrue();
        foundStats.ifPresent(stats -> {
            assertThat(stats.getUserId()).isEqualTo(userId);
            assertThat(stats.getXp()).isEqualTo(200);
            assertThat(stats.getLevel()).isEqualTo(10);
            assertThat(stats.getCoins()).isEqualTo(100);
            assertThat(stats.getGems()).isEqualTo(50);
        });
    }
}
