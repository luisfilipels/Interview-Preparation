package Extras.LeetCode;

import java.util.HashMap;

public class BurstBalloons {

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
            Object[] currentDp = new Object[] {nums, i};
            int winByCurrent;
            int current;
            int [] newArray;
            if (!dp.containsKey(currentDp)) {
                newArray = burst(nums, i);
                dp.put(currentDp, new Object[] {newArray, valAtIndex(nums, i)});
                winByCurrent = (Integer) dp.get(currentDp)[1];
                current = currentVal + winByCurrent;
                max = Math.max(max, current);
            } else {
                newArray = (int[])dp.get(currentDp)[0];
                winByCurrent = (int)dp.get(currentDp)[1];
                current = currentVal + winByCurrent;
                max = Math.max(max, current);
            }

            helper(newArray, current);
        }
    }

    public static void main(String[] args) {
        int [] ints = new int[] {3, 1, 5, 8};
        System.out.println(maxCoins(ints));
    }

}
