package Extras.LeetCode;

import java.util.Arrays;

public class SortColors {

    private static void sortColors (int [] nums) {
        int zeroIndex = 0;
        int twoIndex = nums.length-1;
        int i = 0;

        while (zeroIndex < twoIndex && i <= twoIndex) {
            if (nums[i] == 0) {
                nums[i++] = nums[zeroIndex];
                nums[zeroIndex++] = 0;
            } else if (nums[i] == 2) {
                nums[i] = nums[twoIndex];
                nums[twoIndex--] = 2;
            } else {
                i++;
            }
        }
    }

    public static void main(String[] args) {
        int [] input = new int[] {0, 1, 2, 0, 2, 2, 1, 0, 1, 1, 1, 0};
        sortColors(input);
        System.out.println(Arrays.toString(input));
    }

}
