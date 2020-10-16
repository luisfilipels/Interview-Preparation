public class RemoveElement {

    private static int removeElement (int [] nums, int val) {

        int count = 0;
        for (int x : nums) {
            count += x == val ? 1 : 0;
        }

        int left = 0, right = nums.length-1;

        while (left < right) {
            if (nums[right] == val) {
                right--;
            } else if (nums[left] == val) {
                nums[left++] = nums[right--];
            } else {
                left++;
            }
        }

        return nums.length - count;
    }

    public static void main(String[] args) {
        int [] arr = new int[] {0, 1, 2, 2, 3, 0, 4, 2};
        int length = removeElement(arr, 0);

        for (int i = 0; i < length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}
