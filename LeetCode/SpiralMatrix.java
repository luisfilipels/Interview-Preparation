import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    private static List<Integer> spiralOrder (int[][] matrix) {
        int hor = 1;
        int vert = 0;

        int numbersRemaining = matrix.length * matrix[0].length;

        List<Integer> result = new ArrayList<>();

        int row = 0, col = 0;
        while (numbersRemaining > 0) {
            result.add(matrix[row][col]);
            matrix[row][col] = Integer.MAX_VALUE;

            if (hor == 1) {
                if (col+1 == matrix[0].length || matrix[row][col+1] == Integer.MAX_VALUE) {
                    hor = 0;
                    vert = 1;
                    row++;
                } else {
                    col++;
                }
            } else if (hor == -1) {
                if (col-1 == -1 || matrix[row][col-1] == Integer.MAX_VALUE) {
                    hor = 0;
                    vert = -1;
                    row--;
                } else {
                    col--;
                }
            } else if (vert == 1) {
                if (row+1 == matrix.length || matrix[row+1][col] == Integer.MAX_VALUE) {
                    hor = -1;
                    vert = 0;
                    col--;
                } else {
                    row++;
                }
            } else if (vert == -1) {
                if (row-1 == -1 || matrix[row-1][col] == Integer.MAX_VALUE) {
                    hor = 1;
                    vert = 0;
                    col++;
                } else {
                    row--;
                }
            }

            numbersRemaining--;
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                {1},
                {5},
                {9}
        };

        System.out.println(spiralOrder(matrix));
    }

}
