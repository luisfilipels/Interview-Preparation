package Extras.LeetCode;

import java.util.HashMap;

public class PartitionEqualSubsetSum {

    // New DP solution (fully mine, and faster :D)
    /*
    Before delving into the solution itself, notice that the summation of all the elements in our nums array MUST be even. If it's odd, we would have one partition summing up to
    an odd number and the other, to an even number, and that goes against what's asked.
    If we were to solve this question in a brute force manner, we could consider that we have two empty partitions. Let's call them left and right. Consider the following example:
    [1 5 11 5]
    For each element in the array, we can either add it to left partition, or to the right partition. So let's do so, for each element, using the following notation:
    x -> Sum in left partition
    y -> Sum in right partition
    Going up, we add the number at index idx into the left partition. Going down, we do the same, but to the right partition.
    Let's consider inserting first into the left partition.

idx: 0 1    2               3

              ______________22
             |              0
             |
            17              17
        ___  0______________5
       |
       6     6              11 <---
     _ 0 __ 11 _____________11 <--- Solution
    |        |
 __\ 1       |______________6
   / 0                      16
    |_
       1 __ 12_______________17
       5     5               5
       |     |__________
       |___ 1  ___...   |___ 12
            16               10
             |____...

     Notice that if we do the same considering the first insertion into the right partition, we will essentially have a mirror of what we see above.
     Also notice that that, for any idx we may be at, we take into the next iteration the value that's currently in the left partition, and what's in the right partition, and our index.
     Thus, our brute force code is quite simple:

     public boolean canPartition(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        if (total % 2 != 0) {
            return false;
        } else {
            return helper(nums, 0, 0, 0);
        }
    }

     boolean helper (int [] nums, int currentPos, int left, int right) {
        if (currentPos == nums.length) { // If we added all numbers into the partitions...
            return left == right;        // we return true if both partitions sum up to the same value. Else, false.
        }
        // Else, we consider if either summing the current value to the left partition or to the right partition are true
        return helper(nums, currentPos + 1, left + nums[currentPos], right) || helper(nums, currentPos + 1, left, right + nums[currentPos]);
    }

    How could we improve the above solution though?
    First, consider that "int total" must be even, and that total/2 == total/2. With this, we could get rid of taking with us one of the partitions into the next recursive call.
    Why? Because, if we take total/2 into the recursion, then whenever currentSum == total/2, that means that we reached the solution. Also, notice that, instead of considering
    that we take the values of two partitions into the recursion, we could instead consider that we either take the current number into the next call, or not. We could "pretend"
    that by not taking the current value in the array, we are actually inserting it into the other partition.
    Next, notice that, with the above, the only variables we are taking into recursive calls are the index we are currently at (currentPos) and the value of the sum of all
    elements in the partition we are summing into (currentSum). With this, we can memoize these values into a HashMap, with the key being (currentPos + " " + currentSum), and the
    value being a boolean indicating if with this combination of currentPos and currentSum a solution is reachable or not. Thus, we arrive at the following code:
     */

    static boolean canPartition(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        if (total % 2 != 0) {   // If the total sum of the array is odd, there's no way we could partition it in the way the question asks to.
            return false;
        } else {
            return helper(nums, 0, 0, total/2, new HashMap<>());
        }
    }

    static boolean helper (int [] nums, int currentPos, int currentSum, int totalHalf, HashMap<String, Boolean> hash) {
        String current = currentPos + " " + currentSum;
        if (hash.containsKey(current)) {
            return hash.get(current);
        }
        if (currentSum == totalHalf) {
            hash.put(current, true);
            return true;
        }
        if (currentSum > totalHalf || currentPos == nums.length) {  // If the currentSum is greater than totalHalf, further adding values into currentSum will be useless, since there are only positive integers.
            hash.put(current, false);
            return false;
        }
        hash.put(current, helper(nums, currentPos + 1, currentSum + nums[currentPos], totalHalf, hash) || helper(nums, currentPos + 1, currentSum, totalHalf, hash));
        return hash.get(current);
    }

    // First DP solution. Passes, but is slow and uses too much space.
    /*enum cases{
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
    }*/

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
