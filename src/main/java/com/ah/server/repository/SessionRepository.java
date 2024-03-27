package com.ah.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ah.server.model.Session;

public interface SessionRepository extends JpaRepository<Session, Long> {

}
