package org.example.codility.math;

public class GCD {

    public static int solution(int x, int y) {
        while (y != 0) {
            int tmp = y;
            y = x % y;
            x = tmp;
        }

        return x;
    }

    public static int gcd(int x, int y) {
        int min = Math.min(x, y);

        for (int i = min; i >= 1; i--) {
            if (x % i == 0 && y % i == 0) {
                return i;
            }
        }
        return 1;
    }

    public static int gcd2(int x, int y) {
        if (y == 0) {
            return x;
        }

        return gcd2(y, x % y);
    }

    public static int one(int x, int y) {
        int min = Math.min(x, y);

        for (int i = min; i > 0; i--) {
            if (x % i == 0 && y % i == 0) {
                return i;
            }
        }
        return 1;
    }

    public static int two(int x, int y) {
        if (y == 0) {
            return x;
        }

        return two(y, x % y);
    }
}
