package Extras.HackerRank;

import java.util.Arrays;

public class GreedyFlorist {

    static int getMinimumCost(int k, int[] c) {
        Arrays.sort(c);
        int cost = 0;
        int n = c.length-1;
        int person = 0;
        int multiplier = 1;
        for (int i = n; i >= 0; i--) {
            cost += c[i] * multiplier;
            person++;
            if (person == k) {
                person = 0;
                multiplier++;
            }
        }
        return cost;
    }

    public static void main(String[] args) {
        int [] arr = new int[] {2,5,6};
        System.out.println(getMinimumCost(3, arr));
        System.out.println(Integer.MAX_VALUE);
    }

}
