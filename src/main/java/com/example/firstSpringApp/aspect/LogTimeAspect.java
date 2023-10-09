package com.example.firstSpringApp.aspect;

import com.example.firstSpringApp.services.UserServices;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class LogTimeAspect {
    Logger logger = LoggerFactory.getLogger(LogTimeAspect.class);

    @Around(value = "execution(* com.example.firstSpringApp.services..*(..))") // class value method
    public Object logTime(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Log Time Aspect");
        long startTime = System.currentTimeMillis();
        String methodName = joinPoint.getSignature().toShortString();
        logger.info("==== Method Name is {}", methodName);
        Object result = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        logger.info("==== Method Execution Time: {} ms", (endTime - startTime));
        return result;
    }

}
