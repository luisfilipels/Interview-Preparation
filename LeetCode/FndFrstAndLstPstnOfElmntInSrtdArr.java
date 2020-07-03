package Extras.LeetCode;

import java.util.Arrays;

public class FndFrstAndLstPstnOfElmntInSrtdArr {

    // Keep on doing a binary search, even if you find the number to find first the leftmost index, then to find the
    // rightmost one.

    private static int [] searchRange (int [] nums, int target) {
        int [] returnRange = new int[] {-1, -1};
        if (nums.length == 0) {
            return returnRange;
        }
        int left = findLeft(nums, target);

        if (left == nums.length || nums[left] != target) {
            return returnRange;
        }

        returnRange[0] = left;
        returnRange[1] = findRight(nums, target) - 1;

        return returnRange;
    }

    private static int findLeft (int [] nums, int target) {
        int low = 0, high = nums.length, mid;
        while (low < high) {
            mid = low + (high-low)/2;
            if (nums[mid] > target || nums[mid] == target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private static int findRight (int [] nums, int target) {
        int low = 0, high = nums.length, mid;
        while (low < high) {
            mid = low + (high-low)/2;
            if (nums[mid] > target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int [] nums = new int[] {1,0};
        System.out.println(Arrays.toString(searchRange(nums, 0)));
    }

}
