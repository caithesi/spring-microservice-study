package com.optimagrowth.license.service;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@Bulkhead(name = "mockBulkheadThreadPool", type = Bulkhead.Type.THREADPOOL)
public class TestResilience4jTwoTypeBulkheadDummyService {

    @Bulkhead(name = "mockBulkheadSemaphore")
    public String testBulkheadMockOnFunction(long sleep) {
        try {
            Thread.sleep(sleep);
            return "by some magic, this  bulkhead success";
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
