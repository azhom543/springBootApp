package com.example.firstSpringApp.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class LogMethodNameAspect {
    Logger logger = LoggerFactory.getLogger(LogMethodNameAspect.class);
    @Around(value = "execution(* com.example.firstSpringApp.services..*(..))") // class value method
    public Object logMethodName(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Log Method Name Aspect");
        long startTime = System.currentTimeMillis();
        String methodName = joinPoint.getSignature().toShortString();
        logger.info("==== Method Name is {}", methodName);
        Object result = joinPoint.proceed();
        return result;
    }
}
