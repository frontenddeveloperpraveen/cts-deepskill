package com.library.repository;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {
    public void findBooks() {
        System.out.println("BookRepository findBooks: fetching books from repository");
    }
}
