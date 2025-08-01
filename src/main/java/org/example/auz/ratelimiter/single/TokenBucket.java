package org.example.auz.ratelimiter.single;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * using AtomicInteger to impl token bucket
 *
 * single node, multi-thread safe
 *
 * We want to allow, say, 5 requests per second.
 * We use a "bucket" that holds tokens (permissions to make a request).
 * Each request takes 1 token.
 * Tokens refill every second.
 * If no token? Then we reject the request.
 */
public class TokenBucket {
    private final int capacity = 5;
    private final AtomicInteger tokens = new AtomicInteger(5);

    private final ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);

    public TokenBucket() {
        executorService.scheduleAtFixedRate(() -> {
            if (tokens.get() < capacity) {
                tokens.incrementAndGet();
            }
        }, 0, 200, TimeUnit.MILLISECONDS);
    }

    public boolean allowRequest() {
        if (tokens.get() > 0) {
            tokens.getAndDecrement();
            return true;
        }
        return false;
    }
}
