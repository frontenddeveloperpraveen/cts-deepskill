package com.library.service;

import com.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    private BookRepository bookRepository;

    // Default constructor
    public BookService() {}

    // Constructor Injection (Exercise 7)
    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("BookService: Constructor injection invoked");
    }

    // Setter Injection (Exercise 2, 5, 7)
    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("BookService: Setter injection invoked");
    }

    public BookRepository getBookRepository() {
        return this.bookRepository;
    }

    public void execute() {
        System.out.println("BookService execute: calling BookRepository...");
        bookRepository.findBooks();
    }
}
