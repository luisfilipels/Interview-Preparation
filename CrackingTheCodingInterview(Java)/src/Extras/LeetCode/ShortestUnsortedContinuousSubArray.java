package Extras.LeetCode;

import java.util.Arrays;

public class ShortestUnsortedContinuousSubArray {

    private static int findUnsortedSubarray (int [] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        boolean foundPossibleStart = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i-1]) {
                foundPossibleStart = true;
            }
            if (foundPossibleStart) {
                min = Math.min(min, nums[i]);
            }
        }
        boolean foundPossibleEnd = false;
        for (int i = nums.length-2; i >= 0; i--) {
            if (nums[i] > nums[i+1]) {
                foundPossibleEnd = true;
            }
            if (foundPossibleEnd) {
                max = Math.max(max, nums[i]);
            }
        }
        int left, right;
        for (left = 0; left < nums.length-1; left++) {
            if (nums[left] > min) {
                break;
            }
        }
        for (right = nums.length-1; right >= 0; right--) {
            if (nums[right] < max) {
                break;
            }
        }
        if (right - left < 0) {
            return 0; // Already sorted
        } else {
            return right-left + 1;
        }
    }

    /*
    // My first solution. O(n log(n)) time, O(n) space.
    private static int findUnsortedSubarray (int [] nums) {
        int [] sortedArray = new int[nums.length];
        System.arraycopy(nums, 0, sortedArray, 0, nums.length);
        Arrays.sort(sortedArray);
        int start = 0;
        int end = nums.length-1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != sortedArray[i]) {
                start = i;
                break;
            }
            if (i == nums.length-1 && nums[i] == sortedArray[i]) {
                return 0;
            }
        }
        for (int i = nums.length-1; i >= 0; i--) {
            if (nums[i] != sortedArray[i]) {
                end = i;
                break;
            }
        }
        return end-start + 1;
    }

    */

    public static void main(String[] args) {
        //int [] input = new int[] {2,6,4,8,10,9,15};
        int [] input = new int[] {1,3,8,2,6,3,5,9};
        System.out.println(findUnsortedSubarray(input));
    }

}
