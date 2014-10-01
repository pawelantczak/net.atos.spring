package net.atos.spring.greetings;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GreetingsAspect {

    private Logger log = Logger.getLogger(GreetingsAspect.class);

    @Before("execution(* net.atos.spring.greetings.Greetings.sayHello(..))")
    public void doBefore(JoinPoint joinPoint) {
        log.info(
            "***AspectJ*** DoBefore() is running!! intercepted : " + joinPoint.getSignature()
                .getName());
    }

    @After("execution(* net.atos.spring.greetings.Greetings.sayHello(..))")
    public void doAfter(JoinPoint joinPoint) {
        log.info(
            "***AspectJ*** DoAfter() is running!! intercepted : " + joinPoint.getSignature()
                .getName());
    }
}
