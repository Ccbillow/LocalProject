package org.example.interview.singleton;

/**
 * Advantages:
 * Efficient because it only synchronizes the first time.
 * Ensures thread safety.
 *
 * Disadvantages:
 * More complex than other methods.
 * Requires volatile to prevent instruction reordering.
 */
public class DoubleCheckedLockingSingleton {

    // volatile Prevents instruction reordering and ensures visibility, avoiding partially initialized objects.
    private static volatile DoubleCheckedLockingSingleton instance;

    private DoubleCheckedLockingSingleton() {}

    public static DoubleCheckedLockingSingleton getInstance() {
        if (instance == null) { // Avoid unnecessary locking, improving performance.
            synchronized (DoubleCheckedLockingSingleton.class) {
                if (instance == null) { //Avoid double instantiation when multiple threads are waiting for the lock
                    return new DoubleCheckedLockingSingleton();
                }
            }
        }

        return instance;
    }
}
