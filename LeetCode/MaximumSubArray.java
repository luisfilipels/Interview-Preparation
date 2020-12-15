package Extras.LeetCode;

public class MaximumSubArray {

    // My new solution. O(n) time, O(1) space. No DP. Slightly faster
    private static int maxSubArray(int[] nums) {
        int n = nums.length;

        int currentSum = 0, maxSum = -1, maxVal = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            currentSum += nums[i];
            maxVal = Math.max(maxVal, nums[i]);
            if (currentSum < 0) {
                currentSum = 0;
            } else if (currentSum > maxSum){
                maxSum = currentSum;
            }
        }
        if (maxVal < 0) return maxVal;
        return maxSum;
    }

    // New solution. Easier to understand.
    // https://www.youtube.com/watch?v=tinz1fiYv0c
    /*private static int maxSubArray(int[] nums) {
        int [] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i-1] + nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }*/

    /*private static int maxSubArray(int[] nums) {
        int maxSoFar=nums[0], maxEndingHere=nums[0];
        for (int i=1;i < nums.length;++i){
            maxEndingHere = Math.max(maxEndingHere+nums[i],nums[i]); // Choose between the current number (which starts a new max subarray), or continuing a previous subarray.
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }*/

    /*
    // My solution. Accepted, but uses too much time and space.
    private static int maxSubArray (int [] nums) {
        int max = Integer.MIN_VALUE;
        int current;
        for (int start = 0; start < nums.length; start++) {
            current = nums[start];
            max = Math.max(max, current);
            for (int end = start+1; end < nums.length; end++) {
                current = current + nums[end];
                max = Math.max(max, current);
            }
        }
        return max;
    }
    */

    public static void main(String[] args) {
        int [] input = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(input));
    }

}
