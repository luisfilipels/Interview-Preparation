package Extras.LeetCode;

public class MaximalSquare {

    private static int maximalSquare (char [][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int [][] newMatrix = new int[matrix.length][matrix[0].length];
        int returnInt = 0;
        for (int l = 0; l < matrix.length; l++) {
            for (int c = 0; c < matrix[0].length; c++) {
                if (matrix[l][c] == '0') {
                    newMatrix[l][c] = 0;
                } else {
                    if (l > 0 && c > 0) {
                        newMatrix[l][c] = Math.min(Math.min(newMatrix[l-1][c-1], newMatrix[l-1][c]), newMatrix[l][c-1]) + 1;
                    } else {
                        newMatrix[l][c] = 1;
                    }
                    returnInt = Math.max(returnInt, newMatrix[l][c]);
                }
            }
        }
        return returnInt * returnInt;
    }

    /*
    // Alternative answer.
    static int maximalSquare(char[][] matrix) {
        int returnInt = 0;
        for (int l = 0; l < matrix.length; l++) {
            matrix[l][0] -= '0';
            returnInt = Math.max(returnInt, matrix[l][0]);
        }
        for (int c = 1; c < matrix[0].length; c++) {
            matrix[0][c] -= '0';
            returnInt = Math.max(returnInt, matrix[0][c]);
        }
        for (int l = 1; l < matrix.length; l++) {
            for (int c = 1; c < matrix[0].length; c++) {
                if (matrix[l][c] == '1') {
                    matrix[l][c] = (char)(Math.min(matrix[l][c-1], Math.min(matrix[l-1][c], matrix[l-1][c-1])) + (char)(1));
                    returnInt = Math.max(returnInt, matrix[l][c]);
                } else {
                    matrix[l][c] = 0;
                }
            }
        }
        return returnInt * returnInt;
    }
     */

    public static void main(String[] args) {
        char [][] matrix = new char[][] {
                {'0', '1', '1', '0', '1'},
                {'1', '1', '0', '1', '0'},
                {'0', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'0', '1', '1', '1', '1'},
        };
        System.out.println(maximalSquare(matrix));
    }
}
