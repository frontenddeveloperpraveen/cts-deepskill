package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppenderLoggingExample {
    private static final Logger logger = LoggerFactory.getLogger(AppenderLoggingExample.class);

    public static void main(String[] args) {
        logger.debug("Debug event: starting appender logging test");
        logger.info("Info event: application configuration loaded successfully");
        logger.warn("Warn event: resources usage is near threshold levels");
        logger.error("Error event: database connection timeout occurred");
    }
}
