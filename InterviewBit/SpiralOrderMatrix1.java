package Extras.InterviewBit;

import java.util.ArrayList;
import java.util.List;

class SpiralOrderMatrix1 {

    public static void print2DMatrix(int [][] input) {
        int N = input.length;
        int M = input[0].length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(input[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> A) {
        int m = A.size();
        int n = A.get(0).size();
        int [][] marcados = new int[m][n];
        int i, j;
        int hor, vert;
        i = j = 0;
        hor = 1;
        vert = 0;

        ArrayList<Integer> returnArray = new ArrayList<>();
        while (returnArray.size() <= (m * n)-1) {
            marcados[i][j]++;
            returnArray.add(A.get(i).get(j));
            if (hor == 1 && vert == 0) {
                if (j+hor < n && marcados[i][j+hor] < marcados[i][j]) {
                    j += hor;
                } else {
                    hor = 0;
                    vert = 1;
                    i += vert;
                    j += hor;
                }
            } else if (hor == 0 && vert == 1) {
                if (i+vert < m && marcados[i+vert][j] < marcados[i][j]) {
                    i += vert;
                } else {
                    hor = -1;
                    vert = 0;
                    i += vert;
                    j += hor;
                }
            } else if (hor == -1 && vert == 0) {
                if (j+hor >= 0 && marcados[i][j+hor] < marcados[i][j]) {
                    j += hor;
                } else {
                    hor = 0;
                    vert = -1;
                    i += vert;
                    j += hor;
                }
            } else if (hor == 0 && vert == -1) {
                if (i+vert >= 0 && marcados[i+vert][j] < marcados[i][j]) {
                    i += vert;
                } else {
                    hor = 1;
                    vert = 0;
                    i += vert;
                    j += hor;
                }
            }
        }
        for (int x = 0; x < returnArray.size(); x++) {
            System.out.print(returnArray.get(x));
        }
        return returnArray;
    }

    public static void main(String[] args) {
        int [][] entry = {
                {1, 2, 3, 1},
                {4, 5, 6, 2},
                {7, 8, 9, 3}
        };
        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
        for (int i = 0; i < entry.length; i++) {
            arrayList.add(new ArrayList<Integer>());
            for (int j = 0; j < entry[0].length; j++) {
                arrayList.get(i).add(entry[i][j]);
            }
        }
        spiralOrder(arrayList);
        for (int x = 0; x < arrayList.size(); x++) {
            System.out.print(arrayList.get(x));
        }
    }
}
