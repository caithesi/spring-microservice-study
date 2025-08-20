package com.optimagrowth.license.service;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.apache.juli.logging.Log;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
@Slf4j
public class TestResilience4jRetry {

    @Retry(name = "testWithBulkHead")
    @Bulkhead(name = "testWithRetry")
    public String test(long sleep) {
        log.info("call test with retry and bulkhead");
        try {
            Thread.sleep(sleep);
            return "by some magic, this  bulkhead success";
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
