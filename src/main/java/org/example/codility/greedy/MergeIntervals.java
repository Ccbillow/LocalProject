package org.example.codility.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * 输入：一组区间，例如 [[1,3], [2,6], [8,10], [15,18]]
 * 输出：合并重叠区间后：[[1,6], [8,10], [15,18]]
 */
public class MergeIntervals {

    public static int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }

        Arrays.sort(intervals, Comparator.comparing(a -> a[0]));

        LinkedList<int[]> merged = new LinkedList<>();
        for (int[] interval : intervals) {
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            } else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {
                {1, 3}, {2, 6}, {8, 10}, {15, 18}
        };

        System.out.println(Arrays.toString(merge(intervals)));;
        System.out.println(Arrays.toString(solution(intervals)));;
        System.out.println(Arrays.toString(aaa(intervals)));;
    }

    public static int[][] solution(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing(a -> a[0]));
        LinkedList<int[]> result = new LinkedList<>();
        for (int[] tmp : intervals) {
            if (result.isEmpty()) {
                result.add(tmp);
            } else {
                if (result.getLast()[1] < tmp[0]) {
                    result.add(tmp);
                } else {
                    result.getLast()[1] = Math.max(result.getLast()[1], tmp[1]);
                }
            }
        }

        int[][] res = new int[result.size()][];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        return res;
    }

    public static int[][] aaa(int[][] arrs) {
        List<int[]> res = new ArrayList<>();
        for (int[] arr : arrs) {
            if (res.isEmpty()) {
                res.add(arr);
            } else {
                if (arr[0] < res.get(res.size() - 1)[1]) {
                    res.get(res.size() - 1)[1] = arr[1];
                } else {
                    res.add(arr);
                }
            }
        }

        int[][] result = new int[res.size()][];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }
}
