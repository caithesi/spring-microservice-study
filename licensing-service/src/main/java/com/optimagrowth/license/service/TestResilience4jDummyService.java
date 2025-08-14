package com.optimagrowth.license.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeoutException;

@Service
@CircuitBreaker(name = "licenseService")
public class TestResilience4jDummyService {

    @CircuitBreaker(name = "licenseService",
            fallbackMethod = "testCircuitBreakerMockDBCallFallback")
    public String testCircuitBreakerMockDBCall(boolean shouldFail) {
        if (shouldFail) {
            try {
                Thread.sleep(5000);
                throw new java.util.concurrent.TimeoutException();
            } catch (InterruptedException | TimeoutException e) {
                throw new RuntimeException(e);
            }
        }
        return "by some magic, this success";
    }

    public String testCircuitBreakerMockOnClass(boolean shouldFail) {
        if (shouldFail) {
            try {
                Thread.sleep(5000);
                throw new java.util.concurrent.TimeoutException();
            } catch (InterruptedException | TimeoutException e) {
                throw new RuntimeException(e);
            }
        }
        return "by some magic, this success";
    }


    private String testCircuitBreakerMockDBCallFallback(boolean shouldFail, Throwable t) {
        return "a";
    }
}
