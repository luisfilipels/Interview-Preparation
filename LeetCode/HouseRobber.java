package Extras.LeetCode;

import java.util.Arrays;

public class HouseRobber {

    private static int rob (int [] nums) {
        dp = new int[nums.length + 1];
        Arrays.fill(dp, -1);
        return helper(nums, 0);
    }

    private static int [] dp;

    private static int helper (int [] nums, int currentNum) {
        if (currentNum >= nums.length) {
            return 0;
        }
        if (dp[currentNum] != -1) {
            return dp[currentNum];
        }
        dp[currentNum] = Math.max(helper(nums, currentNum + 1), helper(nums, currentNum + 2) + nums[currentNum]);
        return dp[currentNum];
    }

    public static void main(String[] args) {
        int [] input = new int[] {2, 7, 9, 3, 1};
        //int [] input = new int[] {1, 2, 3, 1};
        System.out.println(rob(input));
    }

}
