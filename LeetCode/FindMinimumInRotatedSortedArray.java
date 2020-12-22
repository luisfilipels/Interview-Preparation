public class FindMinimumInRotatedSortedArray {

    private static int findMin(int[] nums) {
        int start = 0, end = nums.length-1;

        while (true) {
            if (end - start == 1) return Math.min(nums[start], nums[end]);
            int mid = (start + end) / 2;
            if (nums[start] > nums[mid] && nums[mid] < nums[end]) {
                end = mid;
            } else if (nums[start] < nums[mid] && nums[mid] > nums[end]){
                start = mid;
            } else {
                return nums[start];
            }
        }
    }

}
