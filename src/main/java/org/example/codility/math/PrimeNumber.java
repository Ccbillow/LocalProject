package org.example.codility.math;

/**
 * isPrime(2) → true
 *
 * isPrime(4) → false
 *
 * isPrime(17) → true
 *
 * isPrime(100) → false
 */
public class PrimeNumber {

    public static boolean solution(int n) {
        if (n <= 1) {
            return false;
        }

        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static boolean prime(int n) {
        if (n <= 1) {
            return false;
        }

        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean aaa(int n) {
        if (n == 1) {
            return true;
        }

        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
