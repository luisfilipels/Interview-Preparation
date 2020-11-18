import java.util.Arrays;

public class SetMatrixZeroes {

    private static void setZeroes(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        boolean firstColIsZero = false;
        for (int r = 0; r < n; r++) {
            if (matrix[r][0] == 0) firstColIsZero = true;
            for (int c = 1; c < m; c++) {
                if (matrix[r][c] != 0) continue;
                matrix[r][0] = 0;
                matrix[0][c] = 0;
            }
        }

        for (int r = 1; r < n; r++) {
            for (int c = 1; c < m; c++) {
                if (matrix[r][0] == 0 || matrix[0][c] == 0) {
                    matrix[r][c] = 0;
                }
            }
        }

        if (matrix[0][0] == 0) {
            for (int c = 1; c < m; c++) {
                matrix[0][c] = 0;
            }
        }

        if (firstColIsZero) {
            for (int r = 0; r < n; r++) {
                matrix[r][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                {},{1,0,1},{1,1,1}
        };

        setZeroes(matrix);

        System.out.println(Arrays.deepToString(matrix));
    }

}
