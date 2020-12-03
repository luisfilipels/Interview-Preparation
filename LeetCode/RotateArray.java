import java.util.Arrays;

public class RotateArray {

    // Time: O(k * n) Space: O(1)
    /*private static void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;

        if (k == 0) return;

        for (int i = 0; i < k; i++) {
            int firstNum = nums[n-1];
            int bkp = nums[0];
            for (int j = 1; j < n; j++) {
                int temp = nums[j];
                nums[j] = bkp;
                bkp = temp;
            }
            nums[0] = firstNum;
        }
    }*/

    // Time: O(n) Space: O(n)
    /*private static void rotate (int [] nums, int k) {
        int n = nums.length;
        k %= n;

        if (k == 0) return;

        int [] newArr = new int[n];

        for (int i = k, j = 0; i < n; i++, j++) {
            newArr[i] = nums[j];
        }
        for (int i = 0, j = n - k; i < k; i++, j++) {
            newArr[i] = nums[j];
        }

        for (int i = 0; i < n; i++) {
            nums[i] = newArr[i];
        }
    }*/

    // Time: O(n) Space: O(1)
    private static void rotate (int[] nums, int k) {
        int n = nums.length;
        k %= n;
        reverse(nums, 0, n-1);
        reverse(nums, k, n-1);
        reverse(nums, 0, k-1);
    }

    private static void reverse (int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1,2,3,4,5};

        rotate(arr, 2);
        System.out.println(Arrays.toString(arr));
    }

}
