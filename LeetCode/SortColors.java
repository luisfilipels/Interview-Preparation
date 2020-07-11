package Extras.LeetCode;

import java.util.Arrays;


public class SortColors {

    static void swap (int [] nums, int i, int j) {
        int swap = nums[i];
        nums[i] = nums[j];
        nums[j] = swap;
    }

    //https://www.youtube.com/watch?v=uvB-Ns_TVis

    private static void sortColors (int [] nums) {
        int start = 0;              // Where the next 0 should be.
        int end = nums.length-1;    // Where the next 2 should be.
        int index = 0;

        while (index <= end && start < end) {
            if (nums[index] == 0) {
                nums[index] = nums[start];
                nums[start] = 0;
                start++;
                index++;
            } else if (nums[index] == 2) {
                nums[index] = nums[end];
                nums[end] = 2;
                end--;
            } else {
                index++;
            }
        }
    }

    // Solutions below are mine
    /*private static void sortColors (int [] nums) {
        //Moving 2 to the end
        int i = 0, j = nums.length-1;
        while (i < j) {
            if (nums[i] == 2 && nums[j] != 2) {
                swap(nums, i, j);
                i++;
                j--;
            } else if (nums[i] != 2 && nums[j] != 2) {
                i++;
            } else if (nums[i] != 2 && nums[j] == 2) {
                j--;
            } else {
                j--;
            }
        }
        i = 0;
        // Moving 1 behind the 2
        while (i < j) {
            if (nums[j] == 2) j--;
            if (nums[i] == 1 && nums[j] != 1) {
                swap(nums, i, j);
                i++;
                j--;
            } else if (nums[i] != 1 && nums[j] != 1) {
                i++;
            } else if (nums[i] != 1 && nums[j] == 1) {
                j--;
            } else {
                j--;
            }
        }

    }*/

    /*
    // Same solution basically
    int i = 0, j = nums.length-1;
        while (i < j) {
            if (nums[i] == 2 && nums[j] != 2) {
                swap(nums, i, j);
                i++;
                j--;
            } else if (nums[i] != 2 && nums[j] != 2) {
                i++;
            } else if ((nums[i] == 2 && nums[j] == 2) || (nums[i] != 2 && nums[j] == 2)) {
                j--;
            }
        }
        i = 0;
        if (nums[j] == 2) {
            j--;
        }
        while (i < j) {
            if (nums[i] == 1 && nums[j] != 1) {
                swap(nums, i, j);
                i++;
                j--;
            } else if (nums[i] != 1 && nums[j] != 1) {
                i++;
            } else if ((nums[i] == 1 && nums[j] == 1) || (nums[i] != 1 && nums[j] == 1)) {
                j--;
            }
        }
    */

    public static void main(String[] args) {
        int [] input = new int[] {2,0,2,1,1,0};
        sortColors(input);
        System.out.println(Arrays.toString(input));
    }

}
