package Extras.LeetCode;

import java.util.Arrays;

// https://www.youtube.com/watch?v=QjEyO1137cM

public class CountingBits {
    static public int[] countBits(int num) {
        if (num == 0) return new int[]{0};
        int [] dp = new int[num + 1];
        dp[0] = 0;
        dp[1] = 1;
        int currentPowerOfTwo = 2;
        for (int i = 2; i <= num; i++) {
            if (i == currentPowerOfTwo * 2) currentPowerOfTwo = i;
            dp[i] = dp[i - currentPowerOfTwo] + 1;
        }
        return dp;
    }

    public static void main(String[] args) {
        int num = 5;
        System.out.println(Arrays.toString(countBits(num)));
    }
}
