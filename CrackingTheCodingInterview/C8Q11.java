public class C8Q11 {

    private static int coins (int n) {
        int [] arr = new int[] {1, 5, 10, 25};

        int [] dp = new int[n+1];
        dp[0] = 1;

        for (int coinIdx = 0; coinIdx < arr.length; coinIdx++) {
            for (int value = arr[coinIdx]; value <= n; value++) {
                dp[value] += dp[value - arr[coinIdx]];
            }
        }
        return dp[n];
    }



    public static void main(String[] args) {
        System.out.println(coins(80));
    }

}
