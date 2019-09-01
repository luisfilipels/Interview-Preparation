package Extras.HackerRank;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FindTheNumber {

    static String findNumber(List<Integer> arr, int k) {
        for (int i : arr) {
            if (i == k) {
                return "YES";
            }
        }
        return "NO";

    }

    public static void main(String[] args) throws IOException {
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        int k = 10;
        System.out.println(findNumber(arr, k));
    }

}
