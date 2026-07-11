package com.library.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.After;

@Aspect
public class LoggingAspect {

    @Before("execution(* com.library.service.BookService.execute(..))")
    public void logBefore() {
        System.out.println("[AOP Before] LoggingAspect: method execution start");
    }

    @After("execution(* com.library.service.BookService.execute(..))")
    public void logAfter() {
        System.out.println("[AOP After] LoggingAspect: method execution end");
    }

    @Around("execution(* com.library.service.BookService.execute(..))")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("[AOP Around] LoggingAspect: Starting execution timer");
        Object proceed = joinPoint.proceed();
        long executionTime = System.currentTimeMillis() - start;
        System.out.println("[AOP Around] LoggingAspect: Execution completed in " + executionTime + " ms");
        return proceed;
    }
}
