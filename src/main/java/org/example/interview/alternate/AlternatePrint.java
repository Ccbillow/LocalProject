package org.example.interview.alternate;

import java.util.concurrent.atomic.AtomicBoolean;

public class AlternatePrint {

    public static void main(String[] args) {
        Print test = new Print();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                test.printA();
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                test.printB();
            }
        }).start();
    }

    static class Print {
        AtomicBoolean allowA = new AtomicBoolean(true);

        synchronized void printA() {
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

        synchronized void printB() {
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
