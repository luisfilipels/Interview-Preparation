import java.util.Arrays;

public class TransposeMatrix {

    private static int[][] transpose (int[][] A) {
        int n = A.length;
        int m = A[0].length;

        int[][] result = new int[m][n];

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                result[col][row] = A[row][col];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] A = new int[][] {
                {1, 2, 3},
                {4, 5, 6}
        };

        System.out.println(Arrays.deepToString(transpose(A)));
    }

}
