package com.mentormate.devcamp.application.engine.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;

/**
 * The Game engine aspect.
 */
@Aspect
@Component
public class GameEngineAspect {

    private static final Logger logger = LoggerFactory.getLogger(GameEngineAspect.class.getCanonicalName());

    /**
     * Time game engine execution object.
     *
     * @param pjp the Proceeding Join Point
     * @return the result object
     * @throws Throwable the throwable
     */
    @Around("execution(* com.mentormate.devcamp.application.engine.GameEngine.execute(..))")
    public Object timeGameEngineExecution(ProceedingJoinPoint pjp) throws Throwable {
        final Instant now = Instant.now();
        logger.info("Start game engine at: {}", now);
        final Object result = pjp.proceed();
        final Duration executionTime = Duration.between(now, Instant.now());
        String time = String.format("%d", executionTime.toNanos() / 1000);
        logger.info("End the game engine at {} duration on the game engine {} micro seconds", new Date(), time);

        return result;
    }
}
