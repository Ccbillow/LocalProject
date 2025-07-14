package org.example.interview.alternate;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 两个线程交替打印A/B
 */
public class AlternatePrint2 {
    public static void main(String[] args) {
        Print test = new Print();
        new Thread(test::printA).start();
        new Thread(test::printB).start();
    }

    static class Print {
        AtomicBoolean allowA = new AtomicBoolean(true);

        void printA() {
            for (int i = 0; i < 10; i++) {
                synchronized (this) {
                    while (!allowA.get()) {
                        try {
                            this.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    allowA.getAndSet(false);
                    System.out.println("A");
                    this.notify();
                }
            }
        }

        void printB() {
            for (int i = 0; i < 10; i++) {
                synchronized (this) {
                    while (allowA.get()) {
                        try {
                            this.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    allowA.getAndSet(true);
                    System.out.println("B");
                    this.notify();
                }
            }
        }
    }
}
