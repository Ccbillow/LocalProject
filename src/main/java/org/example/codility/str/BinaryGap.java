package org.example.codility.str;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Given N = 1041, the function should return 5 (binary: 10000010001)
 *
 * Given N = 32, the function should return 0 (binary: 100000)
 */
public class BinaryGap {

    private AtomicInteger count = new AtomicInteger(0);

    public static int solution(int N) {
        String binary = Integer.toBinaryString(N);

        int max = 0;
        int curr = 0;
        boolean counting = false;

        for (Character c : binary.toCharArray()) {
            if (c == '1') {
                if (counting) {
                    max = Math.max(max, curr);
                }

                counting = true;
                curr = 0;
            } else if (counting) {
                curr++;
            }
        }
        return max;
    }

    public static int gap(int N) {
        String binaryString = Integer.toBinaryString(N);
        int max = 0;
        int curr = 0;
        boolean flag = false;
        for (char c : binaryString.toCharArray()) {
            if ('1' == c) {
                if (flag) {
                    max = Math.max(max, curr);
                }
                curr = 0;
                flag = true;
            } else {
                if (flag) {
                    curr++;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
//        System.out.println(solution(1041));
//        System.out.println(gap(1041));
//
//        System.out.println();
//        System.out.println(solution(32));
//        System.out.println(gap(32));

        System.out.println(aaa(1041));
        System.out.println(aaa(32));
    }

    public static int aaa(int N) {
        String binaryString = Integer.toBinaryString(N);
        int max = 0;
        int curr = 0;

        boolean flag = false;

        for (char c : binaryString.toCharArray()) {
            if ('1' == c) {
                if (flag) {
                    max = Math.max(max, curr);
                }

                curr = 0;
                flag = true;
            } else {
                if (flag) {
                    curr++;
                }
            }
        }
        return max;
    }
}
