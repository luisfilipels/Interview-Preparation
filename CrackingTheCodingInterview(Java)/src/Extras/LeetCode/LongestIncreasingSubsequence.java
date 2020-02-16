package Extras.LeetCode;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    static int lengthOfLIS(int [] nums, int previousIndex, int currentPos, int[][] dp) {
        if (currentPos == nums.length) {
            return 0;
        }

        if (dp[previousIndex + 1][currentPos] != -1) {
            return dp[previousIndex+1][currentPos];
        }

        int takeCurrent = 0;
        if (previousIndex == -1 || nums[currentPos] > nums[previousIndex]) {
            takeCurrent = lengthOfLIS(nums, currentPos, currentPos+1, dp) + 1;
        }
        int dontTakeCurrent = lengthOfLIS(nums, previousIndex, currentPos+1, dp);
        dp[previousIndex+1][currentPos] = Math.max(takeCurrent, dontTakeCurrent);
        return dp[previousIndex+1][currentPos];
    }

    private static int lengthOfLIS (int [] nums) {
        int [][] dp = new int[nums.length+1][nums.length];
        for (int [] line : dp) {
            Arrays.fill(line, -1);
        }
        return lengthOfLIS(nums, -1, 0, dp);
    }

    public static void main(String[] args) {
        int [] input = new int[] {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLIS(input));
    }

}
