package Extras.LeetCode;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    /*
    Take the following example:
    index: 0  1 2 3 4 5  6  7
    nums: [10 9 2 5 3 7 101 18]

    We can get out of an O(n^3) solution and go to an O(n^2) solution by considering a DP array with a bottom-up approach.
    What's the longest increasing subsequence of the array above, from index 0 to index 0 (just number 10)? Logically,
    it's one. Now, what if we consider the following subarray: [10 9] ? It's still one (either considering just 10, or
    just 9). We would have the following array:

    index:  0  1
    nums:  [10 9]
    dp:    [ 1 1]

    Computationally speaking, how can we find out what value dp[1] will have? We can find that out by running through all
    the numbers behind 9 (and smaller than 9), and checking the largest dp value for each index. When we find said value,
    we just add 1 to it and set it as dp[i]. For example:

    index: 0  1 2 3 4 5  6  7
    nums: [10 9 2 5 3 7 101 18]
    dp:   [1  1 1             ]

    What will be that value of dp[3]? It will be dp[2]+1.

    index: 0  1 2 3 4 5  6  7
    nums: [10 9 2 5 3 7 101 18]
    dp:   [1  1 1 2           ]

    And what about dp[4]? Well, we see that behind 3, the only number smaller than 3 is 2 (at index 2). So, dp[4] will be
    dp[2]+1, and so on. In conclusion, we search, for every number i in the array, the number j behind it that has the largest
    dp value and is smaller than i. Thus, O(n^2).

     */

    private static int lengthOfLIS (int [] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int [] dp = new int[nums.length];
        dp[0] = 1;
        int response = 1;
        for (int i = 1; i < dp.length; i++) {
            int maxDP = 0;
            for (int j = i-1; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    maxDP = Math.max(maxDP, dp[j]);
                }
            }
            dp[i] = maxDP + 1;
            response = Math.max(response, dp[i]);
        }
        return response;
    }

    /*
    // Old answer. Takes too long, uses too much space, and is hard to understand.
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
    */

    public static void main(String[] args) {
        int [] input = new int[] {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLIS(input));
    }

}
