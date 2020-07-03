package Extras.LeetCode;

import java.util.Arrays;

// https://www.youtube.com/watch?v=QjEyO1137cM

public class CountingBits {
    static public int[] countBits(int num) {
        int r = 0;  // Indice atual
        int p = 1;  // Potencia de 2 atual
        int [] dp = new int[num+1];
        while (p <= num) {
            while (r < p && r+p <= num) {
                dp[r + p] = dp[r] + 1;
                r++;
            }
            r = 0; p = p << 1;
        }
        return dp;
    }

    public static void main(String[] args) {
        int num = 5;
        System.out.println(Arrays.toString(countBits(num)));
    }
}
