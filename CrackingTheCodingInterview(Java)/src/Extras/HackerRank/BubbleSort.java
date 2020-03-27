package Extras.HackerRank;

import java.util.Arrays;

public class BubbleSort {

    static void swap (int [] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    static void countSwaps (int [] a) {
        int swaps = 0;
        int n = a.length;
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n - 1; j++) {
                // Swap adjacent elements if they are in decreasing order
                if (a[j] > a[j + 1]) {
                    swap(a, j, j+1);
                    swaps++;
                }
            }

        }
        System.out.println("Array is sorted in " + swaps +" swaps.");
        System.out.println("First Element: " + a[0]);
        System.out.println("Last Element: " + a[a.length-1]);
    }

    public static void main(String[] args) {
        int [] a = new int[] {1, 4, 2, 5, 3, 6, 4, 3, 1};
        countSwaps(a);
    }

}
