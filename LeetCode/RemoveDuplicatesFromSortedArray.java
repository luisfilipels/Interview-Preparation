import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {

    private static void swap (int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

    private static int removeDuplicates (int [] nums) {
        int left = 0;
        int right = 1;

        while (right < nums.length) {
            if (nums[left] == nums[right]) {
                right++;
            } else {
                swap(nums, ++left, right++);
            }
        }
        return left+1;
    }

    public static void main(String[] args) {
        int [] nums = new int[] {
                1,1,2
        };
        int result = removeDuplicates(nums);
        for (int i = 0; i < result; i++) {
            System.out.println(nums[i]);
        }
    }

}
