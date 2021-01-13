package Extras.LeetCode;

import java.util.Arrays;

public class NextPermutation {

    // Great explanation: https://www.youtube.com/watch?v=quAS1iydq7U

    public static void nextPermutation (int [] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i == -1) {
            reverse(nums, 0, nums.length-1);
        } else if (i == nums.length - 2) {
            swap(nums, i, i+1);
        } else {
            int j = nums.length-1;

            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
            reverse(nums, i+1, nums.length-1);
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
