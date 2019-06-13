public class C1Q7 {

    public static int[][] rotateMatrix (int [][] input) {
        int N = input[0].length;
        int [][] returnMatrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                returnMatrix[i][j] = input[j][i];
            }
        }
        for (int i = 0; i < N/2; i++) {
            int [] temp = returnMatrix[i];
            returnMatrix[i] = returnMatrix[returnMatrix[0].length - i - 1];
            returnMatrix[returnMatrix[0].length - i - 1] = temp;
        }

        return returnMatrix;
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
                {4, 5, 3, 1},
                {2, 5, 4, 2},
                {1, 3, 2, 3},
                {1, 2, 3, 4}
        };
        print2DMatrix(input);
        input = rotateMatrix(input);
        print2DMatrix(input);

    }
}
