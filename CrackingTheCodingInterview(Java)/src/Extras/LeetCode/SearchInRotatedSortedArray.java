package Extras.LeetCode;

public class SearchInRotatedSortedArray {

    private static int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            if (nums[0] == target) return 0;
            else return -1;
        }
        if (nums.length == 2) {
            if (nums[0] == target) return 0;
            if (nums[1] == target) return 1;
            else return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {           // Try to find where the array is "divided"
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) return mid;
            if (nums[start] == target) return start;
            if (nums[end] == target) return end;
            if (nums[mid] > nums[end]) {
                start = mid + 1;
            } else {
                end = mid;
            }

        }
        int divide = end;
        start = 0;
        end = divide - 1;
        while (start < end) {           // Search on left half
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) return mid;
            if (nums[start] == target) return start;
            if (nums[end] == target) return end;
            if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        start = divide;
        end = nums.length - 1;
        while (start < end) {            // Search on right half
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) return mid;
            if (nums[start] == target) return start;
            if (nums[end] == target) return end;
            if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

    }

}
