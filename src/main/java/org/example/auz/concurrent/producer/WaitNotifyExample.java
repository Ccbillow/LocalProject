package org.example.auz.concurrent.producer;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class WaitNotifyExample {
    private final static Object lock = new Object();
    private final static AtomicInteger count = new AtomicInteger(0);


    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        executor.submit(() -> {
            while (true) {
                synchronized (lock) {
                    while (count.get() == 10) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }

                    System.out.println("producer: " + count.incrementAndGet());
                    lock.notify();
                }

                // business
                try {
                    Thread.sleep(new Random().nextInt(1000));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        executor.submit(() -> {
            while (true) {
                synchronized (lock) {
                    while (count.get() == 0) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }

                    System.out.println("consumer: " + count.decrementAndGet());
                    lock.notify();
                }

                // business
                try {
                    Thread.sleep(new Random().nextInt(2000));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}
