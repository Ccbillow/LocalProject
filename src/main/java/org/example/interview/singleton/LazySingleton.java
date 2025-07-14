package org.example.interview.singleton;

/**
 * Advantages:
 * Simple to implement.
 * Ensures thread safety.
 *
 * Disadvantages:
 * Performance overhead due to method-level synchronized, which blocks all threads even if the instance is already created.
 */
public class LazySingleton {

    private static LazySingleton singleton;

    private LazySingleton() {}

    public static synchronized LazySingleton getInstance() {
        if (singleton == null) {
            singleton = new LazySingleton();
        }
        return singleton;
    }
}
