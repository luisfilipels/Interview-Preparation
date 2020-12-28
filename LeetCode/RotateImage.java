package Extras.LeetCode;

import java.util.Arrays;

public class RotateImage {

    /*static void invertColumn (int [][] matrix, int column) {
        int i = 0;
        int j = matrix.length-1;
        while (i < j) {
            int swap = matrix[i][column];
            matrix[i][column] = matrix[j][column];
            matrix[j][column]= swap;
            i++;
            j--;
        }
    } */
    /*static void rotate(int [][] matrix) {
        for (int column = 0; column < matrix.length; column++) {
            invertColumn(matrix, column);
        }
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = i + 1; j < matrix[i].length; ++j) {
                int swap = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = swap;
            }
        }
    }*/

    static void swap (int [][] matrix, int i1, int i2, int j1, int j2) {
        int swap = matrix[i1][i2];
        matrix[i1][i2] = matrix[j1][j2];
        matrix[j1][j2] = swap;
    }

    static void flipHorizontal (int [][] matrix) {
        int left, right;
        for (int l = 0; l < matrix.length; l++) {
            left = 0;
            right = matrix.length-1;
            while (left < right) {
                swap(matrix, l, left, l, right);
                left++;
                right--;
            }
        }
    }

    static void rotate (int [][] matrix) {
        // First, transpose the matrix
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                swap(matrix, i, j, j, i);
            }
        }
        // Then, flip it horizontally
        flipHorizontal(matrix);

    }

    public static void main(String[] args) {
        int input [][] = new int[][] {
                {5,1,9,11},
                {2,4,8,10},
                {13,3,6,7},
                {15,14,12,16}
        };
        /*int input [][] = new int[][] {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };*/

        //invertLine(input, 0);
        rotate(input);
        System.out.println(Arrays.deepToString(input));
    }

}
