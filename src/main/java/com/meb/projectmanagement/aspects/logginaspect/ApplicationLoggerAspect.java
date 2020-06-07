package com.meb.projectmanagement.aspects.logginaspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class ApplicationLoggerAspect {

    private final Logger log = LoggerFactory.getLogger(this.getClass());


    @Pointcut("within(com.meb.projectmanagement.controllers..*)")
    public void definePackagePointCut() {
        // empty method
    }

    @Around("definePackagePointCut()")
    public Object logAround(ProceedingJoinPoint joinPoint) {

        log.debug("*************** Before Method Execution *************** \n" +
                "{}.{}() with arguments[s] = {}",
                joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(),
                Arrays.toString(joinPoint.getArgs()));
        log.debug("******************************\n\n");

        Object o = null;
        try {

            o = joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        log.debug("*************** After Method Execution *************** \n" +
                        "{}.{}() with arguments[s] = {}",
                joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(),
                Arrays.toString(joinPoint.getArgs()));
        log.debug("******************************\n\n");

        return o;
    }
}
