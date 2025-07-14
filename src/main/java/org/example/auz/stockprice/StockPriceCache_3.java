package org.example.auz.stockprice;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * You need to load stock exchange security codes with price from a database and cache them for performance. The security codes need to be refreshed say every 30 minutes. This cached data needs to be populated and refreshed by a single writer thread and read by several reader threads. How will you ensure that your read/write solution is scalable and thread safe?
 * <p>
 * https://www.java-success.com/java-scenarios-based-interview-questions-answers/
 */
public class StockPriceCache_3 {
    private final ConcurrentHashMap<String, Double> stockCache = new ConcurrentHashMap<>();
    private final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

    public StockPriceCache_3() {
        // first task start -> 30min
        scheduler.scheduleAtFixedRate(this::refreshCache, 0, 30, TimeUnit.MINUTES);
        // first task end -> 30min
//        scheduler.scheduleWithFixedDelay(this::refreshCache, 0, 30, TimeUnit.MINUTES);
    }

    public double getStockPrice(String securityCode) {
        return stockCache.getOrDefault(securityCode, -1.0);

    }

    private void refreshCache() {
        ConcurrentHashMap<String, Double> cache = getCacheFromDB();
        stockCache.clear();
        stockCache.putAll(cache);
    }

    private ConcurrentHashMap<String, Double> getCacheFromDB() {
        ConcurrentHashMap<String, Double> cache = new ConcurrentHashMap<>();
        cache.put("AAA", 187.0);
        cache.put("BBB", 48267.0);
        cache.put("CCC", 978.0);
        return cache;
    }
}
