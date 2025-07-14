package org.example.interview.producer;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Test {
    private static AtomicInteger count = new AtomicInteger(0);

    private static final Object lock = new Object();

    public static void main(String[] args) {
        Test test = new Test();
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

                synchronized (lock) {
                    while (count.get() >= 10) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    count.getAndIncrement();
                    System.out.println("Producer, count:" + count.get());
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
                    Thread.sleep(random.nextInt(2000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
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
                    System.out.println("Consumer, count:" + count.get());
                    lock.notifyAll();
                }
            }
        }
    }
}
