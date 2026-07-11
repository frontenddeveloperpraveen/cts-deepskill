package com.library.boot;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "bootBookRepository")
public interface BookRepository extends JpaRepository<Book, Long> {
}
