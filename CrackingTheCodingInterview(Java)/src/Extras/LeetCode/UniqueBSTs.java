package Extras.LeetCode;

public class UniqueBSTs {

    //Ajuda de: https://www.youtube.com/watch?v=YDf982Lb84o

    private static int numTrees(int n) {
        switch (n) {
            case 0: return 0;
            case 1: return 1;
            case 2: return 2;
            case 3: return 5;
        }
        int [] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5;
        int acumulator = 0;
        for (int i = 4; i < n+1; i++) {
            for (int j = 0; j < i; j++) {
                if (j == 0) {
                    acumulator += dp[i-1-j];
                } else if(j == i-1) {
                    acumulator += dp[j];
                } else {
                    acumulator += dp[j] * dp[i - 1 - j];
                }
            }
            dp[i] = acumulator;
            acumulator = 0;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(numTrees(4));
    }

}
