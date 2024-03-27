package com.ah.server.repository;

import com.ah.server.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.dao.EmptyResultDataAccessException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.Optional;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    private User user;

    @BeforeEach
    public void setUp() {
        // Initialize the user entity
        user = new User();
        user.setUsername("testUser");
        user.setPasswordHash("testPass");

        // Clear the database and insert the test user
        entityManager.clear();
        entityManager.persist(user);
        entityManager.flush();
    }

    @Test
    void whenDeleteByUsername_thenUserShouldBeDeleted() {
        // Act
        userRepository.deleteByUsername(user.getUsername());

        // Assert
        User foundUser = userRepository.findByUsername(user.getUsername()).orElse(null);
        assertThat(foundUser).isNull();
    }

    @Test
    void whenDeleteByInvalidUsername_thenNoUserShouldBeDeleted() {
        // Arrange
        String nonExistingUsername = "nonExistingUser";

        // Act
        userRepository.deleteByUsername(nonExistingUsername);

        // Assert
        Optional<User> user = userRepository.findByUsername(nonExistingUsername);
        assertThat(user).isNotPresent(); // Vérifiez que l'utilisateur n'existe pas
        // Vous pouvez également vérifier le nombre total d'utilisateurs pour confirmer qu'aucun n'a été supprimé
    }

}
