package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ExceptionThrowerTest {
    @Test
    public void testException() {
        ExceptionThrower thrower = new ExceptionThrower();
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> thrower.throwException()
        );
        assertEquals("Expected exception thrown", exception.getMessage());
    }
}
