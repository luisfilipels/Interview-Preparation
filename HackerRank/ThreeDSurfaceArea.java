public class ThreeDSurfaceArea {

    static boolean isValid (int [][] A, int l, int c) {
        return (l >= 0 && l < A.length && c >= 0 && c < A[0].length);
    }

    static int surfaceArea (int[][] A) {
        int sum = 2 * A.length * A[0].length;

        for (int l = 0; l < A.length; l++) {
            for (int c = 0; c < A[0].length; c++) {
                if (isValid(A, l+1, c)) {
                    if (A[l+1][c] > A[l][c]) sum += A[l+1][c] - A[l][c];
                }
                else sum += A[l][c];
                if (isValid(A, l-1, c)) {
                    if (A[l-1][c] > A[l][c]) sum += A[l-1][c] - A[l][c];
                }
                else sum += A[l][c];
                if (isValid(A, l, c+1)) {
                    if (A[l][c+1] > A[l][c]) sum += A[l][c+1] - A[l][c];
                }
                else sum += A[l][c];
                if (isValid(A, l, c-1)) {
                    if (A[l][c-1] > A[l][c]) sum += A[l][c-1] - A[l][c];

                }
                else sum += A[l][c];
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        int[][] A = new int[][] {
                {1, 3, 4},
                {2, 2, 3},
                {1, 2, 4},
        };
        System.out.println(surfaceArea(A));
    }

}
