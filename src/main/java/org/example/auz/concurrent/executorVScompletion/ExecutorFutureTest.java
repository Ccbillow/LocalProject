package org.example.auz.concurrent.executorVScompletion;

import org.example.auz.concurrent.DateUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * A ----------
 * B ---
 * C --
 * D ----
 * abcd
 *
 * --->
 *
 * A ----------abcd
 * B ---
 * C --
 * D ----
 */
public class ExecutorFutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        System.out.println(Thread.currentThread().getName() + " start..." + DateUtil.getDateTime());

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        List<Future<Integer>> futures = new ArrayList<>();
        futures.add(executorService.submit(() -> {
            try {
                Thread.sleep(10000L);
                System.out.println(Thread.currentThread().getName() + ", TaskA, 10s," + DateUtil.getDateTime());
                return 10;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }));
        futures.add(executorService.submit(() -> {
            try {
                Thread.sleep(3000L);
                System.out.println(Thread.currentThread().getName() + ", TaskB, 3s," + DateUtil.getDateTime());
                return 3;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }));
        futures.add(executorService.submit(() -> {
            try {
                Thread.sleep(2000L);
                System.out.println(Thread.currentThread().getName() + ", TaskC, 2s, " + DateUtil.getDateTime());
                return 2;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }));
        futures.add(executorService.submit(() -> {
            try {
                Thread.sleep(4000L);
                System.out.println(Thread.currentThread().getName() + ", TaskD, 4s," + DateUtil.getDateTime());
                return 4;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }));

        System.out.println(Thread.currentThread().getName() + " 111..." + DateUtil.getDateTime());
        for (Future<Integer> future : futures) {
            Integer i = future.get();
            System.out.println(i);
        }
        System.out.println(Thread.currentThread().getName() + " 222..." + DateUtil.getDateTime());
    }
}
