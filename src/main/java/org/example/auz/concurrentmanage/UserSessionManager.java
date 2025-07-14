package org.example.auz.concurrentmanage;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class UserSessionManager {
    private static final AtomicInteger users = new AtomicInteger(0);
    private static final Semaphore semaphore = new Semaphore(3);

    public static void login() {
        try {
            semaphore.acquire();
            int andIncrement = users.incrementAndGet();

            System.out.println("User login, active users:" + andIncrement);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void logout() {
        int andDecrement = users.decrementAndGet();
        semaphore.release();

        System.out.println("User logout, active users:" + andDecrement);

    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(UserSessionManager::login).start();
        }

        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        for (int i = 0; i < 3; i++) {
            new Thread(UserSessionManager::logout).start();
        }
    }
}
