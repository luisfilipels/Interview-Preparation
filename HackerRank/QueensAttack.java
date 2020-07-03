package Extras.HackerRank;

import java.util.HashSet;

public class QueensAttack {

    static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {
        int result = 0;
        HashSet<String> hash = new HashSet<>();

        for (int[] obstacle : obstacles) {
            hash.add(obstacle[0] + " " + obstacle[1]);
        }

        for (int rd = 1; rd >= -1; rd--) {
            for (int cd = 1; cd >= -1; cd--) {
                if (rd == 0 && cd == 0) continue;
                int currRow = r_q + rd;
                int currCol = c_q + cd;
                while (currCol >= 1 && currCol <= n && currRow >= 1 && currRow <= n) {
                    String current = currRow + " " + currCol;
                    if (hash.contains(current)) {
                        break;
                    } else {
                        result++;
                    }
                    currRow += rd;
                    currCol += cd;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int n = 5;
        int k = 3;
        int r_q = 4;
        int c_q = 3;
        int [][] obstacles = new int[][] {
                {5,5},
                {4,2},
                {2,3}
        };

        System.out.println(queensAttack(n, k, r_q, c_q, obstacles));
    }

}
