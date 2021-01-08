public class DecodeWays {

    private static int numDecodings (String s) {
        if (s.charAt(0) == '0') return 0;
        if (s.length() == 1) return 1;

        int n = s.length();
        int [] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int considerOne = Integer.parseInt(s.charAt(i-1) + "");
            int considerTwo = Integer.parseInt(s.charAt(i-2) + ""+ s.charAt(i-1));

            if (considerOne > 0) dp[i] += dp[i-1]; // If it's 0, we can't consider this position alone
            if (considerTwo >= 10 && considerTwo <= 26) dp[i] += dp[i-2];
        }

        return dp[n];
    }

    public static void main(String[] args) {
        String string = "01";
        System.out.println(numDecodings(string));
    }

}
