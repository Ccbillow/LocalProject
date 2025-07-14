package org.example.auz.stockprice;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * You need to load stock exchange security codes with price from a database and cache them for performance. The security codes need to be refreshed say every 30 minutes. This cached data needs to be populated and refreshed by a single writer thread and read by several reader threads. How will you ensure that your read/write solution is scalable and thread safe?
 *
 * https://www.java-success.com/java-scenarios-based-interview-questions-answers/
 */
public class StockPriceCache_2 {
    private final Map<String, Double> stockCache = new HashMap<>();
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

    public StockPriceCache_2() {
        scheduler.scheduleAtFixedRate(this::refreshCache, 0, 30, TimeUnit.MINUTES);
    }

    public double getStockPrice(String securityCode) {
        lock.readLock().lock();
        try {
            return stockCache.getOrDefault(securityCode, -1.0);
        } finally {
            lock.readLock().unlock();
        }
    }

    private void refreshCache() {
        lock.writeLock().lock();
        try {
            Map<String, Double> cache = getCacheFromDB();
            stockCache.clear();
            stockCache.putAll(cache);
        } finally {
            lock.writeLock().unlock();
        }
    }

    private Map<String, Double> getCacheFromDB() {
        Map<String, Double> cache = new HashMap<>();
        cache.put("AAA", 187.0);
        cache.put("BBB", 48267.0);
        cache.put("CCC", 978.0);
        return cache;
    }
}
