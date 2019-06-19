package Extras.InterviewBit;

import java.util.ArrayList;
import java.util.Arrays;

public class PascalTriangle {

    public static ArrayList<ArrayList<Integer>> pTriangle (int A) {
        ArrayList<ArrayList<Integer>> pTri = new ArrayList<>();
        if (A <= 0) {
            return pTri;
        }
        pTri.add(new ArrayList<>());
        pTri.get(0).add(1);
        for (int i = 1; i < A; i++) {
            pTri.add(new ArrayList<>());
            pTri.get(i).add(1);
            for (int j = 1; j <= i; j++) {
                int a, b;
                try {
                    a = pTri.get(i-1).get(j);
                } catch (Exception e) {
                    a = 0;
                }
                try {
                    b = pTri.get(i-1).get(j-1);
                } catch (Exception e) {
                    b = 0;
                }
                pTri.get(i).add(a + b);
            }
        }
        return pTri;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> pt = new ArrayList<>();
        pt = pTriangle(0);
        for (ArrayList<Integer> integers : pt) {
            for (Integer integer : integers) {
                System.out.print(integer);
            }
            System.out.println();
        }
    }
}
