package com.ebugtracker.admin.config;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

@Aspect
@Slf4j
@Configuration
public class AspectConfig {

    @Before("execution(public * com.ebugtracker.admin.service.*.*(..))")
    public void logBeforeAllMethodExecution(JoinPoint joinPoint){
        log.info("******"+joinPoint.getSignature().getName() +" Started ******");
    }

    @After("execution(public * com.ebugtracker.admin.service.*.*(..))")
    public void logAfterAllMethodExecution(JoinPoint joinPoint){
        log.info("******"+joinPoint.getSignature().getName() +" Ended ******");
    }


}
