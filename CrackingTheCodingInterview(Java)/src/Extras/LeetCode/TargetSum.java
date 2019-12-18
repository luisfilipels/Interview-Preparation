package Extras.LeetCode;

import java.util.Arrays;

public class TargetSum {

    private static int findTargetSumWays (int [] nums, int S) {
        int [][] dp = new int[nums.length][2001]; // 0 a 1000 -> somas negativas. 1001 a 2001 -> somas positivas
        for (int [] row : dp) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }
        return helper(nums, S, 0, 0, dp);
    }

    private static int helper (int [] nums, int S, int currentIndex, int currentSum, int[][] dp) {
        if (currentIndex == nums.length-1 && (currentSum + nums[currentIndex] == S || currentSum - nums[currentIndex] == S)) {
            if (nums[currentIndex] == 0) {
                return 2;
            }
            return 1;
        } else if (currentIndex == nums.length-1 && (currentSum + nums[currentIndex] != S || currentSum - nums[currentIndex] != S)) {
            return 0;
        } else {
            if (dp[currentIndex][currentSum + 1000] != Integer.MIN_VALUE) {
                return dp[currentIndex][currentSum + 1000];
            }
            dp[currentIndex][currentSum + 1000] = helper(nums, S, currentIndex+1, currentSum + nums[currentIndex], dp) + helper(nums, S, currentIndex+1, currentSum - nums[currentIndex], dp);
            return dp[currentIndex][currentSum+1000];
        }
    }

    public static void main(String[] args) {
        int [] input = new int[] {1, 1, 1, 1, 1};
        System.out.println(findTargetSumWays(input, 3));
    }

}
