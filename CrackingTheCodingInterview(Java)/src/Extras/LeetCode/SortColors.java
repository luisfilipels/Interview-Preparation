package Extras.LeetCode;

import java.util.Arrays;

public class SortColors {

    static void swap (int [] nums, int i, int j) {
        int swap = nums[i];
        nums[i] = nums[j];
        nums[j] = swap;
    }

    private static void sortColors (int [] nums) {
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

    }

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
        int [] input = new int[] {2, 0, 1};
        sortColors(input);
        System.out.println(Arrays.toString(input));
    }

}
