package Extras.LeetCode;

public class DecodeWays {

    private static int numDecodings (String s) {
        int n = s.length();

        int [] dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i <= n; i++) {
            String considerOne = s.charAt(i-1) + "";
            String considerTwo = s.charAt(i-2) + "" + s.charAt(i-1);
            int valueOne = Integer.parseInt(considerOne);
            int valueTwo = Integer.parseInt(considerTwo);
            if (valueOne >= 1) {
                dp[i] += dp[i - 1];            // If it's 0, we can't consider this position alone
            }
            if (valueTwo >= 10 && valueTwo <= 26) {
                dp[i] += dp[i-2];
            }
        }
        return dp[n];

    }

    public static void main(String[] args) {
        String string = "201210210";
        System.out.println(numDecodings(string));
    }

}
