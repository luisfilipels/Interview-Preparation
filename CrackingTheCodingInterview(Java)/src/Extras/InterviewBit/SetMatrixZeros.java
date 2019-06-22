package Extras.InterviewBit;

import java.util.ArrayList;

public class SetMatrixZeros {

    public static void zeroMatrix(ArrayList<ArrayList<Integer>> a) {
        int m = a.size();
        int n = a.get(0).size();
        ArrayList<ArrayList<Integer>> coordinates = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (a.get(i).get(j) == 0) {
                    coordinates.add(new ArrayList<>());
                    coordinates.get(coordinates.size()-1).add(i);
                    coordinates.get(coordinates.size()-1).add(j);
                }
            }
        }
        for (int i = 0; i < coordinates.size(); i++) {
            int line = coordinates.get(i).get(0);
            int column = coordinates.get(i).get(1);
            for (int x = 0; x < n; x++) {
                a.get(line).set(x, 0);
            }
            for (int y = 0; y < m; y++) {
                a.get(y).set(column, 0);
            }
        }
        /*for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (a.get(i).get(j) == 0) {
                    a.get(i).set(j, Integer.MAX_VALUE-98);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (a.get(i).get(j) == Integer.MAX_VALUE-98) {
                    a.get(i).set(j, 0);
                    for (int x = 0; x < n; x++) {
                        if (a.get(i).get(x) != Integer.MAX_VALUE-98)
                        a.get(i).set(x, 0);
                    }
                    for (int x = 0; x < m; x++) {
                        if (a.get(x).get(j) != Integer.MAX_VALUE-98)
                        a.get(x).set(j, 0);
                    }
                }
            }
        }*/
        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < a.get(0).size(); j++) {
                System.out.print(a.get(i).get(j));
            }
            System.out.println();
        }


    }

    public static void main(String[] args) {
        /*int [][] input = {
                {0, 0},
                {1, 1}
        };*/
        int [][] input = {
                {1, 2, 1, 0},
                {1, 2, 1, 3},
                {0, 1, 2, 3}
        };
        ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            a.add(new ArrayList<>());
            for (int j = 0; j < input[i].length; j++) {
                a.get(i).add(input[i][j]);
            }
        }
        zeroMatrix(a);

    }
}
