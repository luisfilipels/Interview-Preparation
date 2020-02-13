package Extras.LeetCode;

import java.util.HashMap;

public class PartitionEqualSubsetSum {

    // First DP solution. Passes, but is slow and uses too much space.
    enum cases{
        UNKNOWN, TRUE, FALSE
    }

    private static boolean canPartition(int [] nums) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        if (total % 2 != 0) {
            return false;
        } else {
            cases[][] dp = new cases[total+1][nums.length+1];
            for (cases [] line : dp) {
                for (int i = 0; i < line.length; i++) {
                    line[i] = cases.UNKNOWN;
                }
            }
            return helper(nums, 0, 0, total, dp);
        }
    }

    private static boolean helper (int [] nums, int pos, int currentSum, int total, cases [][] dp) {
        if (dp[currentSum][pos] != cases.UNKNOWN) {
            return dp[currentSum][pos] == cases.TRUE;
        }
        if (currentSum == total / 2) {
            dp[currentSum][pos] = cases.TRUE;
            return true;
        }
        if (currentSum > total / 2 || pos >= nums.length) {
            dp[currentSum][pos] = cases.FALSE;
            return false;
        }
        boolean take = helper(nums, pos + 1, currentSum + nums[pos], total, dp);
        boolean dontTake = helper(nums, pos + 1, currentSum, total, dp);
        dp[currentSum][pos] = (take || dontTake) ? cases.TRUE : cases.FALSE;
        return take || dontTake;
    }

    /*
    // Alternative solution. TLE for some reason.
    private static boolean canPartition(int [] nums) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        if (total % 2 != 0) {
            return false;
        } else {
            return helper(nums, 0, 0, total, new HashMap<>());
        }
    }

    private static boolean helper (int [] nums, int pos, int currentSum, int total, HashMap<String, Boolean> dp) {
        String current = currentSum + " " + pos;
        if (dp.containsKey(current)) {
            return dp.get(current);
        }
        if (currentSum == total / 2) {
            dp.put(current, true);
            return true;
        }
        if (currentSum > total / 2 || pos >= nums.length) {
            dp.put(current, false);
            return false;
        }
        boolean take = helper(nums, pos + 1, currentSum + nums[pos], total, dp);
        boolean dontTake = helper(nums, pos + 1, currentSum, total, dp);
        dp.put(current, take || dontTake);
        return take || dontTake;
    }
    */



    public static void main(String[] args) {
        int [] input = new int[] {1, 2, 5};
        System.out.println(canPartition(input));
    }

}
