package Extras.InterviewBit;

public class SearchInRotatedSortedArray {

    private static int search (int [] nums, int target) {
        if (nums.length == 1) {
            if (nums[0] == target) return 0;
            else return -1;
        }
        int start = 0;
        int end = nums.length-1;
        while (start < end) {
            if (Math.abs(start - end) == 1) {
                if (nums[start] == target) {
                    return start;
                } else if (nums[end] == target) {
                    return end;
                } else {
                    return -1;
                }
            }
            int mid = start + (end - start)/2;
            if (nums[mid] == target) return mid;
            if (nums[start] == target) return start;
            if (nums[end] == target) return end;
            if (nums[start] < nums[end]) {
                if (nums[mid] > target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (nums[mid] > nums[start]) {
                    if (nums[mid] > target && nums[start] <= target) {
                        end = mid - 1;
                    } else {
                        start = mid + 1;
                    }
                } if (nums[mid] < nums[end]) {
                    if (target < nums[end] && target >= nums[mid]) {
                        start = mid + 1;
                    } else {
                        end = mid - 1;
                    }
                }

            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int [] input = {5, 1, 2, 3, 4};
        System.out.println(search(input, 7));
    }

}
