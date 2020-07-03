package Extras.HackerRank;

import java.util.Arrays;

public class MarkAndToys {

    static int maximumToys (int [] prices, int k) {
        Arrays.sort(prices);
        for (int i = 0; i < prices.length; i++) {
            k -= prices[i];
            if (k == 0) {
                return i+1;
            }
            if (k < 0) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        //int [] prices = new int[] {1, 12, 5, 111, 200, 1000, 10};
        int [] prices = new int[] {1, 2, 3, 4};
        System.out.println(maximumToys(prices, 7));
    }

}
