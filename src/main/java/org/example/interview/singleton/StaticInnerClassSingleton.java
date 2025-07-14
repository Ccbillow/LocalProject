package org.example.interview.singleton;

/**
 * Advantages:
 * Lazy initialization (only created when getInstance() is called).
 * Thread-safe without synchronization.
 * Efficient (no locking overhead).
 *
 * Disadvantages:
 * Slightly harder to understand compared to eager initialization.
 */
public class StaticInnerClassSingleton {
    private StaticInnerClassSingleton(){}

    private static class Instance {
        private static final StaticInnerClassSingleton instance = new StaticInnerClassSingleton();
    }

    public static StaticInnerClassSingleton getInstance() {
        return Instance.instance;
    }
}
