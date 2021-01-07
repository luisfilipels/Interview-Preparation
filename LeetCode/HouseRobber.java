package Extras.LeetCode;

import java.util.Arrays;

public class HouseRobber {

    // Bottom-up solution. O(1) extra space
    private static int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int n = nums.length;

        int take = nums[0];
        int notTake = 0;

        for (int i = 1; i < n; i++) {
            int bkpTake = take;

            take = Math.max(nums[i], notTake + nums[i]);
            notTake = Math.max(bkpTake, notTake);
        }

        return Math.max(take, notTake);
    }

    // Bottom-up solution. O(n) extra space
    private static int rob2(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int n = nums.length;

        int [] take = new int[n];
        int [] notTake = new int[n];

        take[0] = nums[0];

        for (int i = 1; i < n; i++) {
            take[i] = Math.max(nums[i], notTake[i-1] + nums[i]);
            notTake[i] = Math.max(take[i-1], notTake[i-1]);
        }

        return Math.max(take[n-1], notTake[n-1]);
    }

    /*
    // Top-down solution
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
    }*/

    public static void main(String[] args) {
        int [] input = new int[] {2, 7, 9, 3, 1};
        //int [] input = new int[] {1, 2, 3, 1};
        System.out.println(rob(input));
    }

}
