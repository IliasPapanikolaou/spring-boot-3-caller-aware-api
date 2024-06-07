package com.ipap.springboot3customannotationapi.annotation;

import com.ipap.springboot3customannotationapi.config.CallerProperties;
import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.server.ResponseStatusException;

@Aspect
@Component
public class CallerCheckAspect {

    Logger log = LoggerFactory.getLogger(this.getClass());

    private final CallerProperties callerProperties;

    public CallerCheckAspect(CallerProperties callerProperties) {
        this.callerProperties = callerProperties;
    }

    @Before("@annotation(com.ipap.springboot3customannotationapi.annotation.CallerCheck)")
    public void checkCaller(JoinPoint joinPoint) {
        HttpServletRequest request =
                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String callerId = request.getHeader("X-Caller-ID");

        if (callerId == null || callerId.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Caller ID is required");
        }

        CallerProperties.Caller caller = callerProperties.getCallers().stream()
                .filter(c -> c.getId().equals(callerId))
                .findFirst()
                .orElse(null);

        log.info("Saving caller ID {} for method {}", callerId, joinPoint.getSignature().getName());

        if (caller == null) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Invalid caller ID");
        }

        CallerContext.setCallerName(caller.getName());
    }

    @After("@annotation(com.ipap.springboot3customannotationapi.annotation.CallerCheck)")
    public void clearCallerContext() {
        CallerContext.clear();
    }
}

