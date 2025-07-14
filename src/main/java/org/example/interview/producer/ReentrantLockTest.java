package org.example.interview.producer;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {
    private static AtomicInteger count = new AtomicInteger(0);
    private static Lock lock = new ReentrantLock();

    private static Condition full = lock.newCondition();
    private static Condition empty = lock.newCondition();

    public static void main(String[] args) {
        ReentrantLockTest test = new ReentrantLockTest();
        new Thread(test.new Producer()).start();
        new Thread(test.new Consumer()).start();
    }

    class Producer implements Runnable {
        Random random = new Random();

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(random.nextInt(2000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                try {
                    lock.lock();
                    while (count.get() >= 10) {
                            full.await();

                    }
                    count.getAndIncrement();
                    System.out.println("Producer, count:" + count.get());
                    empty.signal();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    class Consumer implements Runnable {
        Random random = new Random();

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(random.nextInt(2000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                try {
                    lock.lock();
                    while (count.get() == 0) {
                        empty.await();
                    }
                    count.getAndDecrement();
                    System.out.println("Consumer, count:" + count.get());
                    full.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}
