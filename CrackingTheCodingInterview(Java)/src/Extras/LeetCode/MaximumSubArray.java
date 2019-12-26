package Extras.LeetCode;

public class MaximumSubArray {

    private static int maxSubArray(int[] nums) {
        int maxSoFar=nums[0], maxEndingHere=nums[0];
        for (int i=1;i < nums.length;++i){
            maxEndingHere = Math.max(maxEndingHere+nums[i],nums[i]); // Choose between the current number (which starts a new max subarray), or continuing a previous subarray.
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }

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
