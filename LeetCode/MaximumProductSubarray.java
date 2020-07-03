package Extras.LeetCode;

public class MaximumProductSubarray {

    private static int maxProduct (int [] nums) {
        if (nums.length == 1) return nums[0];
        int currentProduct = 1;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                currentProduct = 1;
                continue;
            }
            currentProduct *= nums[i];
            max = Math.max(currentProduct, max);
        }
        currentProduct = 1;
        for (int i = nums.length-1; i >= 0; i--) {
            if (nums[i] == 0) {
                currentProduct = 1;
                continue;
            }
            currentProduct *= nums[i];
            max = Math.max(currentProduct, max);
        }
        return max;
    }

    // My first solution. Fool's errand.
    /*private static int maxProduct (int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[][] dp = new int[nums.length][nums.length];
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            dp[0][i] = nums[i];
            max = Math.max(max, dp[0][i]);
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                dp[i][j] = nums[j] * dp[i-1][j-1];
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }*/

    public static void main(String[] args) {
        int [] input = new int[] {-3, 0, 1, -2};
        System.out.println(maxProduct(input));
    }

}
