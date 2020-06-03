package Extras.HackerRank;

import java.util.ArrayList;
import java.util.Arrays;

public class CountingInversions {

    static long mergeSortInversions (ArrayList<Integer> list) {
        if (list.size() == 1) {
            return 0;
        }

        long inversions = 0;

        ArrayList<Integer> leftHalf = new ArrayList<>();
        ArrayList<Integer> rightHalf = new ArrayList<>();

        for (int i =  0; i < list.size()/2; i++) {
            leftHalf.add(list.get(i));
        }

        for (int i = list.size()/2; i < list.size(); i++) {
            rightHalf.add(list.get(i));
        }

        inversions += mergeSortInversions(leftHalf);
        inversions += mergeSortInversions(rightHalf);

        leftHalf.add(Integer.MAX_VALUE);
        rightHalf.add(Integer.MAX_VALUE);

        int i = 0, j = 0;
        for (int k = 0; k < list.size(); k++) {
            if (leftHalf.get(i) <= rightHalf.get(j)) {
                list.set(k, leftHalf.get(i++));
            } else {
                list.set(k, rightHalf.get(j++));
                inversions += leftHalf.size() - i - 1;
            }
        }

        return inversions;
    }

    static long countInversions (int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : arr) {
            list.add(i);
        }

        return mergeSortInversions(list);
    }

    public static void main(String[] args) {
        int [] input = new int[] {
                2, 1, 3, 1, 2
        };
        System.out.println(countInversions(input));
    }

}
