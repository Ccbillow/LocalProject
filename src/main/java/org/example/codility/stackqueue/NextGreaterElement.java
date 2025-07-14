package org.example.codility.stackqueue;

import java.util.Arrays;
import java.util.Stack;

/**
 * input: nums = [2, 1, 2, 4, 3]
 * output: [4, 2, 4, -1, -1]
 *
 * For 2, the next greater is 4.
 * For 1, the next greater is 2.
 * For 2, the next greater is 4.
 * For 4, there is no greater, so -1.
 * For 3, there is no greater, so -1.
 */
public class NextGreaterElement {

    // [4, 5, 2, 10]
    public static int[] solution(int[] a) {
        int[] res = new int[a.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = a.length - 1; i >= 0; i--) {
            if (!stack.isEmpty() && stack.peek() <= a[i]) {
                stack.pop();
            }

            res[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(a[i]);
        }

        return res;
    }

    public static int[] aaa(int[] a) {
        int[] res = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            int tmp = a[i];
            boolean flag = false;
            for (int j = i; j < a.length; j++) {
                if (a[j] > tmp) {
                    res[i] = a[j];
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                res[i] = -1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {2, 1, 2, 4, 3};
        System.out.println(Arrays.toString(solution(a)));
        System.out.println(Arrays.toString(aaa(a)));
    }
}
