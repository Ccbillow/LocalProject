package org.example.interview.producer;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 生产者消费者
 */
public class WaitAndNotifyTest {

    private static AtomicInteger count = new AtomicInteger(0);
    private static Object lock = new Object();

    public static void main(String[] args) {
        WaitAndNotifyTest test = new WaitAndNotifyTest();
        new Thread(test.new Producer()).start();
        new Thread(test.new Consumer()).start();
    }

    class Producer implements Runnable {
        Random random = new Random();

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(random.nextInt(3000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (lock) {
                    while (count.get() >= 10) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    count.getAndIncrement();
                    System.out.println("Producer, count:" + count);
                    lock.notifyAll();
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
                    Thread.sleep(random.nextInt(3000));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                synchronized (lock) {
                    while (count.get() == 0) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    count.getAndDecrement();
                    System.out.println("Consumer, count:" + count);
                    lock.notifyAll();
                }
            }
        }
    }

}
