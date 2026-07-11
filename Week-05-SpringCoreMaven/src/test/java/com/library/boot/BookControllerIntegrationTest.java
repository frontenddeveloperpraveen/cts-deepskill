package com.library.boot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = LibraryManagementApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BookControllerIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testCrudOperations() {
        // Create book
        Book book = new Book(1L, "Spring in Action", "Craig Walls");
        ResponseEntity<Book> postResponse = restTemplate.postForEntity("/books", book, Book.class);
        assertEquals(HttpStatus.OK, postResponse.getStatusCode());
        assertNotNull(postResponse.getBody());
        assertEquals("Spring in Action", postResponse.getBody().getTitle());

        // Get books
        ResponseEntity<Book[]> getResponse = restTemplate.getForEntity("/books", Book[].class);
        assertEquals(HttpStatus.OK, getResponse.getStatusCode());
        assertTrue(getResponse.getBody().length > 0);

        // Get book by id
        ResponseEntity<Book> getByIdResponse = restTemplate.getForEntity("/books/1", Book.class);
        assertEquals(HttpStatus.OK, getByIdResponse.getStatusCode());
        assertEquals("Spring in Action", getByIdResponse.getBody().getTitle());

        // Update book
        book.setTitle("Spring in Action (Updated)");
        HttpEntity<Book> requestEntity = new HttpEntity<>(book);
        ResponseEntity<Book> putResponse = restTemplate.exchange("/books/1", HttpMethod.PUT, requestEntity, Book.class);
        assertEquals(HttpStatus.OK, putResponse.getStatusCode());
        assertEquals("Spring in Action (Updated)", putResponse.getBody().getTitle());

        // Delete book
        ResponseEntity<Void> deleteResponse = restTemplate.exchange("/books/1", HttpMethod.DELETE, null, Void.class);
        assertEquals(HttpStatus.OK, deleteResponse.getStatusCode());

        // Verify deletion
        ResponseEntity<Book> getDeletedResponse = restTemplate.getForEntity("/books/1", Book.class);
        assertEquals(HttpStatus.NOT_FOUND, getDeletedResponse.getStatusCode());
    }
}
