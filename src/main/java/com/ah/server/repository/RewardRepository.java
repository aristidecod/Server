package com.ah.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ah.server.model.Reward;
import java.util.List;

public interface RewardRepository extends JpaRepository<Reward, Long> {

}
