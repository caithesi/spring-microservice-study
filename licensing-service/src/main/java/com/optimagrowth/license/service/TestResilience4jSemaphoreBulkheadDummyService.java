package com.optimagrowth.license.service;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import org.springframework.stereotype.Service;

@Service
@Bulkhead(name = "mockBulkheadSemaphore")
public class TestResilience4jSemaphoreBulkheadDummyService {

    @Bulkhead(name = "mockBulkheadSemaphore")
    public String testBulkheadMockOnFunction(long sleep) {
        try {
            Thread.sleep(sleep);
            return "by some magic, this  bulkhead success";
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public String testBulkheadMockOnClass(long sleep) {
        try {
            Thread.sleep(sleep);
            return "by some magic, this  bulkhead success";
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
