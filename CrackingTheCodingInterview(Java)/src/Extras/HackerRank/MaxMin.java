package Extras.HackerRank;

import java.util.Arrays;

public class MaxMin {

    static int maxMin(int k, int [] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        int min = Integer.MAX_VALUE;
        for (int i = k - 1, j = 0; i < n; i++, j++) {
            min = Math.min(min, arr[i] - arr[j]);
        }
        return min;
    }

    public static void main(String[] args) {
        int [] arr = new int[] {10, 100, 300, 200, 1000, 20, 30};
        System.out.println(maxMin(3, arr));
    }

}
