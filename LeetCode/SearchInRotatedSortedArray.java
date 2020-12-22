package Extras.LeetCode;

public class SearchInRotatedSortedArray {

    // Check if the target is between the start and the mid. If so, go to the left half. Else, to the right.
    // If neither is true, then check if the target is between the mid and end. If so, go to the right half. Else, to the left
    private static int search (int[] nums, int target) {
        int start = 0, end = nums.length-1;

        if (nums.length <= 3) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == target) return i;
            }
            return -1;
        }

        while (true) {
            int mid = (start + end)/2;

            int nm = nums[mid];
            int ns = nums[start];
            int ne = nums[end];

            if (ns == target) return start;
            if (nm == target) return mid;
            if (ne == target) return end;

            if (end - start <= 1) return -1;

            if (ne > nm) {
                if (target < ne && target > nm) start = mid+1;
                else end = mid-1;
            }
            if (nm > ns) {
                if (target < nm && target > ns) end = mid-1;
                else start = mid+1;
            }
        }
    }

    public static void main(String[] args) {

    }

}
