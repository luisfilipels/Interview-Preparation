package Extras.LeetCode;

import static Extras.LeetCode.LargestRectangleInHistogram.largestRectangleArea;

public class MaximalRectangle {

    private static int maximalRectangle (char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }

        int [][] newMatrix = new int[matrix.length][matrix[0].length];

        int returnArea = 0;

        for (int c = 0; c < matrix[0].length; c++) {
            newMatrix[0][c] = matrix[0][c] == '1' ? 1 : 0;
        }

        returnArea = Math.max(largestRectangleArea(newMatrix[0]), returnArea);

        for (int l = 1; l < matrix.length; l++) {
            for (int c = 0; c < matrix[0].length; c++) {
                if (matrix[l][c] == '0') {
                    newMatrix[l][c] = 0;
                } else {
                    newMatrix[l][c] = newMatrix[l-1][c] + 1;
                }
            }
            returnArea = Math.max(largestRectangleArea(newMatrix[l]), returnArea);
        }
        return returnArea;
    }

    public static void main(String[] args) {
        char [][] input = new char[][] {
                {'1'}
        };
        /*char [][] input = new char[][] {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };*/
        System.out.println(maximalRectangle(input));
    }

}
