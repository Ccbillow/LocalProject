package org.example.auz.blind75.week2;

/**
 * First Bad Version
 *
 * desc: https://leetcode.com/problems/first-bad-version/description/
 */
public class Num1 {
    public int firstBadVersion(int n) {
        int low = 0;
        int high = n;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (!isBadVersion(mid - 1) && isBadVersion(mid)) {
                return mid;
            } else if (isBadVersion(mid - 1) && isBadVersion(mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return 1;
    }

    private boolean isBadVersion(int n) {
        return false;
    }
}
