import java.util.ArrayList;

public class C1Q8 {

    public static class zeroPosition {
        public int x, y;

        zeroPosition(int x, int y) {
            this.x = x;
            this.y = y;
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

    public static void zeroMatrix (int [][] input) {
        ArrayList<zeroPosition> zeroPositions = new ArrayList<>();
        int M = input.length;
        int N = input[0].length;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (input[i][j] == 0) {
                    zeroPositions.add(new zeroPosition(i, j));
                }
            }
        }
        while (!zeroPositions.isEmpty()) {
            zeroPosition currentPosition = zeroPositions.remove(0);
            for (int y = 0; y < N; y++) {
                input[currentPosition.x][y] = 0;
            }
            for (int x = 0; x < M; x++) {
                input[x][currentPosition.y] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int [][] input = {
                {4, 5, 3, 1},
                {2, 0, 4, 2},
                {1, 3, 2, 3},
                {1, 2, 3, 1}
        };
        print2DMatrix(input);
        zeroMatrix(input);
        print2DMatrix(input);
    }
}
