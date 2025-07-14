package org.example.auz.stockprice;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * You need to load stock exchange security codes with price from a database and cache them for performance. The security codes need to be refreshed say every 30 minutes. This cached data needs to be populated and refreshed by a single writer thread and read by several reader threads. How will you ensure that your read/write solution is scalable and thread safe?
 *
 * https://www.java-success.com/java-scenarios-based-interview-questions-answers/
 */
public class StockPriceCache_1 {
    private final AtomicReference<Map<String, Double>> cache = new AtomicReference<>();

    private final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

    public StockPriceCache_1() {
        scheduler.scheduleAtFixedRate(this::refreshCache, 0, 30, TimeUnit.MINUTES);
    }

    public double getStockPrice(String securityCode) {
        return cache.get().getOrDefault(securityCode, -1.0);
    }

    private void refreshCache() {
        Map<String, Double> newCache = loadCacheFromDB();
        cache.set(newCache);
    }

    private Map<String, Double> loadCacheFromDB() {
        Map<String, Double> cache = new HashMap<>();
        cache.put("AAA", 188.0);
        cache.put("BBB", 1233.0);
        cache.put("CCC", 876.0);
        return cache;
    }
}
