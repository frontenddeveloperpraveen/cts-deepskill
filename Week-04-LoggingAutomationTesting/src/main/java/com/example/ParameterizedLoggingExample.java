package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParameterizedLoggingExample {
    private static final Logger logger = LoggerFactory.getLogger(ParameterizedLoggingExample.class);

    public static void main(String[] args) {
        String username = "Praveen K R";
        int loginAttempts = 3;
        logger.info("User '{}' attempted to log in. Attempt count: {}", username, loginAttempts);
    }
}
