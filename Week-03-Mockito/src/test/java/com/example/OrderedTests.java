package com.example;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderedTests {
    private static StringBuilder executionLog = new StringBuilder();

    @Test
    @Order(1)
    public void firstTest() {
        if (executionLog.length() >= 3) {
            executionLog.setLength(0);
        }
        executionLog.append("1");
        assertEquals("1", executionLog.toString());
    }

    @Test
    @Order(2)
    public void secondTest() {
        executionLog.append("2");
        assertEquals("12", executionLog.toString());
    }

    @Test
    @Order(3)
    public void thirdTest() {
        executionLog.append("3");
        assertEquals("123", executionLog.toString());
    }
}
