package Extras.LeetCode;

import java.util.Arrays;

public class NextPermutation {

    // Great explanation: https://www.youtube.com/watch?v=quAS1iydq7U

    public static void nextPermutation (int [] nums) {
        int startOfDecreasing = nums.length - 2;
        while (startOfDecreasing >= 0 && nums[startOfDecreasing] >= nums[startOfDecreasing + 1]) {
            startOfDecreasing--;
        }
        if (startOfDecreasing == -1) {
            reverse(nums, 0, nums.length-1);
        } else if (startOfDecreasing == nums.length - 2) {
            swap(nums, startOfDecreasing, startOfDecreasing+1);
        } else {
            int smallestGreaterThanStartOfDecreasing = nums.length-1;

            while (smallestGreaterThanStartOfDecreasing >= 0 && nums[smallestGreaterThanStartOfDecreasing] <= nums[startOfDecreasing]) {
                smallestGreaterThanStartOfDecreasing--;
            }
            swap(nums, startOfDecreasing, smallestGreaterThanStartOfDecreasing);
            reverse(nums, startOfDecreasing+1, nums.length-1);
        }
    }

    static void reverse (int [] nums, int from, int to) {
        int i = from, j = to;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    static void swap (int [] nums, int i, int j) {
        int bkp = nums[i];
        nums[i] = nums[j];
        nums[j] = bkp;
    }

    public static void main(String[] args) {
        //int [] nums = new int[] {1, 3, 2, 7, 6, 5, 4};
        int [] nums = new int[] {5, 2, 1};
        //nextPermutation(nums);
        for (int i = 0; i < 5; i++) {
            nextPermutation(nums);
            System.out.println(Arrays.toString(nums));
        }
        //System.out.println(Arrays.toString(nums));
    }

}
