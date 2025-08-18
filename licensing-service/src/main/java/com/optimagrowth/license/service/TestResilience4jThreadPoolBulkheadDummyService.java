package com.optimagrowth.license.service;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

@Service
@Bulkhead(name = "mockBulkheadThreadPool", type = Bulkhead.Type.THREADPOOL)
public class TestResilience4jThreadPoolBulkheadDummyService {

    @Bulkhead(name = "mockBulkheadThreadPool", type = Bulkhead.Type.THREADPOOL)
    public CompletableFuture<String> testBulkheadMockOnFunction(long sleep) {
        try {
            Thread.sleep(sleep);
            return CompletableFuture.completedFuture("by some magic, this  bulkhead success");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public CompletableFuture<String> testBulkheadMockOnClass(long sleep) {
        try {
            Thread.sleep(sleep);
            return CompletableFuture.completedFuture("by some magic, this  bulkhead success");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
