public class C1Q7 {

    static void swap (int[][] input, int r1, int c1, int r2, int c2) {
        int temp = input[r1][c1];
        input[r1][c1] = input[r2][c2];
        input[r2][c2] = temp;
    }

    static int[][] rotateMatrixClockwise(int[][] input) {
        int n = input.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                swap(input, i, j, j, i);
            }
        }
        return input;
    }

    static int[][] rotateMatrixCounterClockWise(int[][] input) {
        int n = input.length;
        for (int x = 0; x < 3; x++) {
            for (int i = 0; i < n; i++) {
                for (int j = i; j < n; j++) {
                    swap(input, i, j, j, i);
                }
            }
            invertMatrixHorizontal(input);
            for (int i = 0; i < n; i++) {
                for (int j = i; j < n; j++) {
                    swap(input, i, j, j, i);
                }
            }
            invertMatrixHorizontal(input);
            for (int i = 0; i < n; i++) {
                for (int j = i; j < n; j++) {
                    swap(input, i, j, j, i);
                }
            }
            invertMatrixHorizontal(input);
        }
        return input;
    }

    static void invertMatrixHorizontal (int[][] input) {
        int n = input.length-1;
        for (int r = 0; r < input.length; r++) {
            int left = 0;
            int right = n;
            while (left < right) {
                swap(input, r, left++, r, right--);
            }
        }
    }

    public static void print2DMatrix(int [][] input) {
        int N = input[0].length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(input[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int [][] input = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 0, 1, 2},
                {3, 4, 5, 6}
        };
        print2DMatrix(input);
        input = rotateMatrixClockwise(input);
        print2DMatrix(input);

    }
}
