package com.ah.server.repository;

import com.ah.server.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    private User user;

    @Test
    void whenFindByUsername_thenReturnUser() {
        // Arrange: Set up the environment
        User user = new User();
        user.setUsername("testUser");
        entityManager.persist(user);
        entityManager.flush();

        // Act: Call the method being tested
        Optional<User> foundUser = userRepository.findByUsername(user.getUsername());

        // Assert: Check the results are as expected
        assertThat(foundUser).isPresent();
        assertThat(foundUser.get().getUsername()).isEqualTo(user.getUsername());
    }

    @Test
    void whenDeleteByUsername_thenUserShouldBeDeleted() {
        // Arrange
        long userId = user.getId();

        // Act
        userRepository.deleteByUsername(user.getUsername());
        Optional<User> deletedUser = userRepository.findById(userId);

        // Assert
        assertThat(deletedUser).isNotPresent();
    }
}