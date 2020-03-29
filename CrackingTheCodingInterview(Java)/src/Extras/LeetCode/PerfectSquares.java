package Extras.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;

public class PerfectSquares {


    /*
    Exemplo para n = 12
    Observe as somas para determinados n:
    0 -> 0
    1 -> 1 (1)
    2 -> 2 (1 + 1)
    3 -> 3 (1 + 1 + 1)
    4 -> 1 (4)
    5 -> 2 (4 + 1)
    6 -> 3 (4 + 1 + 1)
    7 -> 4 (4 + 1 + 1 + 1)
    8 -> 2 (4 + 4)
    9 -> 1 (9)
    10-> 2 (9 + 1)
    11-> 3 (9 + 1 + 1)
    12-> 3 (4 + 4 + 4)

    Tomemos n = 6. A pior soma possível é 1+1+1+1+...+1 = 6.
    Podemos tentar somar com valores maiores que 1 e ver o resultado obtido.
    i = 6
    j = 1
    dp[6] = min (12, dp[6 - 1*1]) + 1 = min(12, dp[5]) + 1 = min (12, 2) + 1 = 3
    j = 2
    dp[6] = min (3,  dp[6 - 2*2]) + 1 = min(3,  dp[2]) + 1 = min (3, 2) +  1 = 3

    Cada posição i será o valor de uma soma passada + 1.
    Para n = 9, por exemplo, teremos as seguintes possibilidades:
    dp[9-1] + 1 = 3
    dp[9-4] + 1 = 3
    dp[9-9] + 1 = 1 // escolhemos esse
    Sempre subtraimos i de um quadrado perfeito (j * j) pois assim sempre teremos como dp[i-j*j] um valor em que só faltará
    somar com outro quadrado perfeito para chegar a i;

    Não podemos fazer 3 * 3 pois sairia um indice negativo.

    Para n = 12 temos a seguinte árvore:

    http://images3.programmersought.com/570/31/313f25ca62733e25a802cd4aa27edf02.png



     */

    private static int numSquares (int n) {
        int [] dp = new int[n+1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int x = 1; x * x <= n; x++) {
                if (i - (x*x) < 0) break;
                min = Math.min(min, dp[i - (x*x)] + 1);
            }
            dp[i] = min;
        }
        return dp[n];
    }

    /*
    // My first brute force solution. Time limit exceeded.

    private static int numSquares (int n) {
        ArrayList<Integer> squares = new ArrayList<>();
        int curr = 1;
        while (curr * curr <= n) {
            squares.add(curr * curr);
            curr++;
        }
        helper(n, 0, squares, new ArrayList<>(), 0);
        return x == Integer.MAX_VALUE ? 0 : x;
    }

    private static int x = Integer.MAX_VALUE;

    private static void helper (int n, int lastSquareIdx, ArrayList<Integer> squares, ArrayList<Integer> current, int currentSum) {
        if (currentSum == n && current.size() < x) {
            x = current.size();
            return;
        } else if (currentSum > n) return;
        for (int i = lastSquareIdx; i < squares.size(); i++) {
            ArrayList<Integer> newList = new ArrayList<>(current);
            newList.add(squares.get(i));
            helper(n , i, squares, newList, currentSum + squares.get(i));
        }
    }
    */

    public static void main(String[] args) {
        System.out.println(numSquares(12));
    }

}
