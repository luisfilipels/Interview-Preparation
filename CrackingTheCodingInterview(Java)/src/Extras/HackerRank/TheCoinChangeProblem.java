package Extras.HackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TheCoinChangeProblem {

    public static long getWays (int n, List<Long> list) {
        int R = list.size()+1, C = n+1;

        long [][] dp = new long[R][C];
        Collections.sort(list);

        for (int r = 0; r < R; r++) {
            dp[r][0] = 1;
        }

        for (int c = 1; c < C; c++) {
            dp[0][c] = 0;
        }

        for (int r = 1; r < R; r++) {
            for (int c = 1; c < C; c++) {
                long sum = dp[r-1][c];
                if (c - list.get(r-1) >= 0) {
                    sum += dp[r][c - Math.toIntExact(list.get(r-1))];
                }
                dp[r][c] = sum;
            }
        }

        return dp[R-1][C-1];
    }

    public static void main(String[] args) {
        long [] arr = new long[] {
                1,2,3
        };
        ArrayList<Long> list = new ArrayList<>();
        for (long i : arr) {
            list.add(i);
        }
        System.out.println(getWays(4, list));
    }

}
