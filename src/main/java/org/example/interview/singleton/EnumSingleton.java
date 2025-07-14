package org.example.interview.singleton;

/**
 * Advantages:
 * Thread-safe by default.
 * Prevents reflection attacks (unlike other methods).
 * Serializable by default.
 *
 * Disadvantages:
 * Not flexible (can't extend other classes).
 * Some developers find it less intuitive.
 */
public enum EnumSingleton {
    Instance;

}
