package Extras.LeetCode;

public class SparseMatrixMultiplication {

    private static int [][] multiply (int [][] A, int [][] B) {
        int[][] response = new int[A.length][B[0].length];
        boolean[] rowA = new boolean[A.length];
        boolean[] colB = new boolean[B[0].length];

        for (int l = 0; l < A.length; l++) {
            for (int c = 0; c < A[0].length; c++) {
                if (A[l][c] != 0) {
                    rowA[l] = true;
                    break;
                }
            }
        }

        for (int l = 0; l < B.length; l++) {
            for (int c = 0; c < B[0].length; c++) {
                if (B[l][c] != 0) {
                    colB[c] = true;
                    break;
                }
            }
        }

        for (int l = 0; l < response.length; l++) {
            for (int c = 0; c < response[0].length; c++) {
                if (!rowA[l] || !colB[c]) { // If a whole matrix or column is zero, skip it.
                    continue;
                }

                for (int i = 0; i < A[0].length; i++) {
                    response[l][c] += A[l][i] * B[i][c];
                }
            }
        }

        return response;
    }

    public static void main(String[] args) {

    }

}
