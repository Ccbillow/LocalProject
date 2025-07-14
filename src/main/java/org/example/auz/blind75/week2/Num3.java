package org.example.auz.blind75.week2;

/**
 * Climbing Stairs
 *
 * desc: https://leetcode.com/problems/climbing-stairs/description/
 *
 *  * Time Complexity: O(n)
 *  * Space Complexity: O(n)
 */
public class Num3 {
    public int climbStairs(int n) {
        if (n < 3) {
            return n;
        }

        int[] result = new int[n+1];
        result[1] = 1;
        result[2] = 2;
        for (int i = 3; i <= n; i++) {
            result[i] = result[i - 1] + result[i - 2];
        }
        return result[n];
    }
}
