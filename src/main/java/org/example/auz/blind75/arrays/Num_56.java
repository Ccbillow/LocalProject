package org.example.auz.blind75.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 56. Merge Intervals
 * https://leetcode.com/problems/merge-intervals/description/
 *
 * time: O(n log (n))
 * space: O(n)
 */
public class Num_56 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> merged = new ArrayList<>();
        int[] tmp = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < tmp[1]) {
                tmp[1] = Math.max(tmp[1], intervals[i][1]);
            } else {
                merged.add(tmp);
                tmp = intervals[i];
            }
        }
        merged.add(tmp);
        return merged.toArray(new int[][]{});
    }
}
