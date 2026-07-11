package com.example.spring.mocking;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MockingUserRepository extends JpaRepository<User, Long> {
}
