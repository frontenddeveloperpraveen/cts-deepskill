package com.library;

import com.library.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import static org.junit.jupiter.api.Assertions.*;

public class SpringCoreTest {
    @Test
    public void testSpringCoreContextAndAop() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookService = context.getBean(BookService.class);
        assertNotNull(bookService);
        assertNotNull(bookService.getBookRepository());
        
        // Execute the service method to verify output and aspect behavior
        bookService.execute();
    }
}
