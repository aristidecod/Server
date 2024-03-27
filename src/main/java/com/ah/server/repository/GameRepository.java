package com.ah.server.repository;

import com.ah.server.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

    @Query("SELECT g.resultat FROM Game g WHERE g.user1.id = :userId OR g.user2.id = :userId")
    List<String> findResultatsByUserId(@Param("userId") Long userId);
}
