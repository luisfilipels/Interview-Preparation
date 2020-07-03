package Extras.LeetCode;

import java.util.HashMap;

public class BurstBalloons {

    // Solução de Tushar Roy. https://www.youtube.com/watch?v=IFNibRVgFBo&t=1104s
    static private int maxCoins (int [] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int dp[][] = new int[nums.length][nums.length];

        for (int len  = 1; len <= nums.length; len++) {
            for (int i = 0; i <= nums.length - len; i++) {
                int j = i + len -1;
                for (int k = i; k <= j; k++) {
                    int left = 1;
                    int right = 1;
                    if (i != 0) left = nums[i-1];
                    if (j != nums.length-1) right = nums[j+1];

                    int before = 0;
                    int after = 0;
                    if (i != k) {
                        before = dp[i][k-1];
                    }
                    if (j != k) {
                        after = dp[k+1][j];
                    }
                    dp[i][j] = Math.max(left * nums[k] * right + before + after, dp[i][j]);
                }
            }
        }
        return dp[0][nums.length-1];
    }

    // Minha solução. "Correta", mas demora MUITO e não é aceita. Força bruta.
    /*
    static int max = 0;

    static int [] burst (int [] nums, int i) {
        int [] newArray = new int[nums.length-1];
        int x = 0;
        for (int j = 0; j < nums.length; j++) {
            if (j != i) {
                newArray[x++] = nums[j];
            }
        }
        return newArray;
    }

    static int valAtIndex (int [] nums, int i) {
        if (i-1 == -1 && i+1 != nums.length) {
            return nums[i] * nums[i+1];
        } else if (i-1 != -1 && i+1 != nums.length) {
            return nums[i-1] * nums[i] * nums[i+1];
        } else if (i-1 != -1 && i+1 == nums.length) {
            return nums[i-1] * nums[i];
        } else {
            return nums[i];
        }
    }

    static private int maxCoins(int [] nums) {
        helper(nums, 0);
        return max;
    }

    static HashMap<Object[], Object[]> dp = new HashMap<>();

    static private void helper (int [] nums, int currentVal) {
        for (int i = 0; i < nums.length; i++) {
            int current = valAtIndex(nums, i) + currentVal;
            int [] newArray = burst(nums, i);
            max = Math.max(max, current);
            helper(newArray, current);
        }
    }
    */


    public static void main(String[] args) {
        int [] ints = new int[] {3, 1, 5, 8};
        System.out.println(maxCoins(ints));
    }

}
