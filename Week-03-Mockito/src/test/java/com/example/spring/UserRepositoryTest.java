package com.example.spring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindByName() {
        User user1 = new User(1L, "Charlie");
        User user2 = new User(2L, "Diana");
        userRepository.save(user1);
        userRepository.save(user2);

        List<User> results = userRepository.findByName("Charlie");
        assertEquals(1, results.size());
        assertEquals("Charlie", results.get(0).getName());
    }
}
