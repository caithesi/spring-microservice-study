package com.optimagrowth.license.controller;

import com.optimagrowth.license.service.TestResilience4jDummyService;
import com.optimagrowth.license.service.TestResilience4jThreadPoolBulkheadDummyService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
@AllArgsConstructor
@RequestMapping(value = "v1/test-resilience4j")
public class TestResilience4j {
    private final TestResilience4jDummyService testResilience4jDummyService;
    private final TestResilience4jThreadPoolBulkheadDummyService testResilience4jThreadPoolBulkheadDummyService;

    @GetMapping("/test-circuit-breaker-on-function-mock-call/{fail}")
    public ResponseEntity<String> testCircuitBreakerMockOnFunction(@PathVariable boolean fail) {
        return ResponseEntity.ok(testResilience4jDummyService.testCircuitBreakerMockOnFunction(fail));
    }

    /**
     * this aim to test when @CircuitBreaker is declared at class level instead of function level
     *
     * @param fail should fail or not
     * @return just a dummy string
     */
    @GetMapping("/test-circuit-breaker-on-class-mock-call/{fail}")
    public ResponseEntity<String> testCircuitBreakerMockOnClass(@PathVariable boolean fail) {
        return ResponseEntity.ok(testResilience4jDummyService.testCircuitBreakerMockOnClass(fail));
    }

    @GetMapping("/test-threadpool-bulkhead-on-function-mock-call/{sleep}")
    public ResponseEntity<String> testBulkheadMockOnFunction(@PathVariable long sleep) throws ExecutionException, InterruptedException {
        String result = testResilience4jThreadPoolBulkheadDummyService.testBulkheadMockOnFunction(sleep).get();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/test-threadpool-bulkhead-on-class-mock-call/{sleep}")
    public ResponseEntity<String> testBulkheadMockOnClass(@PathVariable long sleep) throws ExecutionException, InterruptedException {
        String result = testResilience4jThreadPoolBulkheadDummyService.testBulkheadMockOnClass(sleep).get();
        return ResponseEntity.ok(result);
    }
}
