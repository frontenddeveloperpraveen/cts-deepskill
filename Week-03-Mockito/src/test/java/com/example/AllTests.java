package com.example;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import com.example.advanced.*;
import com.example.spring.*;

@Suite
@SelectClasses({
    CalculatorTest.class,
    AssertionsTest.class,
    BankAccountTest.class,
    EvenCheckerTest.class,
    OrderedTests.class,
    ExceptionThrowerTest.class,
    PerformanceTesterTest.class,
    MyServiceTest.class,
    ServiceTest.class,
    ApiServiceTest.class,
    FileServiceTest.class,
    NetworkServiceTest.class,
    MultiReturnServiceTest.class,
    CalculatorServiceTest.class,
    UserServiceTest.class,
    UserControllerTest.class,
    UserRepositoryTest.class,
    UserIntegrationTest.class,
    CalculatorServiceParameterizedTest.class,
    com.example.spring.mocking.UserControllerTest.class,
    com.example.spring.mocking.UserServiceTest.class,
    com.example.spring.mocking.UserIntegrationTest.class
})
public class AllTests {
}
