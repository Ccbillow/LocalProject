package org.example.interview.singleton;

/**
 * Advantages:
 * Thread-safe by default because the instance is created when the class is loaded.
 * Simple and easy to implement.
 *
 * Aisadvantages:
 * Wastes memory if the instance is never used.
 */
public class HungrySingleton {
    private HungrySingleton(){}

    private static final HungrySingleton singleton = new HungrySingleton();

    public HungrySingleton getSingleton() {
        return singleton;
    }
}
