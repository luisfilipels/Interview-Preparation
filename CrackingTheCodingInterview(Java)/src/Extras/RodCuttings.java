package Extras;

import java.util.Arrays;

public class RodCuttings {

    static int cutRod(int n, int [] priceArray) {
        if (n <= 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, priceArray[i] + cutRod(n - i - 1, priceArray));
        }
        return max;
    }

    static int memoCutRod(int n, int [] priceArray) {
        int [] r = new int[n + 1];
        Arrays.fill(r, Integer.MIN_VALUE);
        return memoCutRodAux(n, priceArray, r);
    }

    static int memoCutRodAux(int n, int [] priceArray, int [] r) {
        if (r[n] >= 0) {
            return r[n]; // Value has been previously calculated.
        }
        int q;
        if (n == 0) {
            q = 0;
        } else {
            q = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                q = Math.max(q, priceArray[i] + memoCutRodAux(n - i - 1, priceArray, r));
            }
        }
        r[n] = q;
        return q;
    }

    public static void main(String[] args) {
        int n = 3;
        int [] priceArray = {1, 5, 8, 9, 10, 17, 20, 24, 30};
        System.out.println(memoCutRod(n,priceArray));
    }

}
