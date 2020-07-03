import java.util.Arrays;

public class C8Q1 {

    public static int countWays(int n)
    {
        if (n < 0) {
            return 0;
        }
        else if (n == 0) {
            return 1;
        } else {
            return countWays(n - 1) + countWays(n - 2) + countWays(n - 3);
        }
    }

    public static int memoCountWays (int n, int [] memo) {
        if (n < 0) {
            return 0;
        } else if (memo[n] > -1) {
            return memo[n];
        } else {
            memo[n] = memoCountWays(n - 1, memo) + memoCountWays(n - 2, memo) + memoCountWays(n - 3, memo);
            return memo[n];
        }
    }

    public static int memoCountWays (int n) {
        int [] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        } else {
            memo [0] = 1;
            memo [1] = 1;
            return memoCountWays(n, memo);
        }
    }

    public static void main(String[] args) {
        int i = 20;
        System.out.println(countWays(i));
        System.out.println(memoCountWays(i));
    }

}
