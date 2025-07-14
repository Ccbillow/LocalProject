package org.example.codility.math;

/**
 * 编写程序，统计 1 到 10,000 中所有满足「各位数字之和为偶数」的数字个数。
 */
public class DigitSumEvenCounter {

    public static int solution() {
        int res = 0;
        for (int i = 1; i <= 10000; i++) {
            if (check(i)) {
                res++;
            }
        }
        return res;
    }

    // 54 / 10 = 5
    // 54 % 10 = 4
    private static boolean check(int num) {
        int sum = 0;
        while (num > 0) {
            sum = sum + num % 10;
            num = num / 10;
        }
        return sum % 2 == 0;
    }


}
