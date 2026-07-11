package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import java.util.concurrent.TimeUnit;

public class PerformanceTesterTest {
    @Test
    @Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
    public void testPerformanceTimeout() {
        PerformanceTester tester = new PerformanceTester();
        tester.performTask();
    }
}
