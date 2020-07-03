package Extras.HackerRank;

import java.util.Arrays;
import java.util.HashSet;

public class Pairs {

    static int pairs(int k, int [] arr) {
        HashSet<Integer> hash = new HashSet<>();
        Arrays.sort(arr);
        int count = 0;
        for (int x : arr) {
            if (hash.contains(x)) {
                count++;
            }
            hash.add(x + k);
        }
        return count;
    }

    public static void main(String[] args) {
        int [] arr = new int[] {3,3,9,9,5};
        int k = 7;
        System.out.println(pairs(k, arr));
    }

}
