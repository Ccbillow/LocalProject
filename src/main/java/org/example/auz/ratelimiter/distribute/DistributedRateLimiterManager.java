package org.example.auz.ratelimiter.distribute;

import org.redisson.api.RRateLimiter;
import org.redisson.api.RedissonClient;
import org.redisson.api.RateType;
import org.redisson.Redisson;
import org.redisson.config.Config;

import java.time.Duration;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;


/**
 * using Redisson to impl distribute token bucket
 *
 * use redis as shared resources
 *
 * 5 requests per second.
 */
public class DistributedRateLimiterManager {

    private final RedissonClient redissonClient;
    private final Map<String, RRateLimiter> limiters = new ConcurrentHashMap<>();

    public DistributedRateLimiterManager() {
        Config config = new Config();
        // todo use real redis config
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");
        this.redissonClient = Redisson.create(config);
    }

    /**
     * init or get rate limiter
     * @param name interface name
     * @param rate tokens per second
     * @param capacity
     * @return RRateLimiter
     */
    public RRateLimiter getOrCreateRateLimiter(String name, long rate, long capacity) {
        return limiters.computeIfAbsent(name, key -> {
            RRateLimiter limiter = redissonClient.getRateLimiter(key);
            limiter.trySetRate(RateType.OVERALL, 5, Duration.ofSeconds(1));
            return limiter;
        });
    }

    /**
     * try to get token
     * @param limiterName interface name
     * @return allow or permit
     */
    public boolean tryAcquire(String limiterName) {
        RRateLimiter limiter = limiters.get(limiterName);
        if (limiter == null) {
            throw new IllegalStateException("RateLimiter not initialized: " + limiterName);
        }
        return limiter.tryAcquire();
    }

    public void shutdown() {
        redissonClient.shutdown();
    }
}
