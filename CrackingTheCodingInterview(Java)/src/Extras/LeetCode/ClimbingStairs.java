package Extras.LeetCode;

public class ClimbingStairs {

    // Pensar o seguinte: Tratando o último passo como tendo um passo, de quantas maneiras posso percorrer os n-1 passos
    // anteriores? OU, se eu considerar o último passo como tendo dois, como posso percorrer os n-2 anteriores? n-3 não
    // interessa, pois cada subida tem um ou dois passos.
    private static int climbStairs (int n) {
        int [] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n+1; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(5));
    }

}
