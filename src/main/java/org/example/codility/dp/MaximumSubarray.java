package org.example.codility.dp;

public class MaximumSubarray {

    public static int max(int[] nums) {
        int currSum = nums[0];
        int maxSum = nums[0];

        for (int i = 0; i < nums.length; i++) {
            currSum = Math.max(nums[i], currSum + nums[i]);
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(max(arr));
    }

    public static int solution(int[] nums) {
        int max = 0;
        int curr = 0;

        for (int i = 0; i < nums.length; i++) {
            curr = Math.max(curr, curr + nums[i]);
            max = Math.max(max, curr);
        }
        return max;
    }
}
