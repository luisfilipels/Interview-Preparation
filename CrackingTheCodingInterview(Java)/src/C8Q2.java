import java.util.*;

public class C8Q2 {

    ArrayList<int []> path = new ArrayList<>();

    public static String get2DArrayPrint(int[][] matrix) {
        String output = new String();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                output = output + (matrix[i][j] + " ");
            }
            output = output + "\n";
        }
        return output;
    }


    static int [][] findCostMatrix (int [][] matrix) {
        int[][] cost = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < cost.length; i++) {
            Arrays.fill(cost[i], -1);
        }
        cost[0][0] = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int valTop;
                int valLeft;
                if (i == 0 && j == 0) {
                    cost[i][j] = 1;
                    continue;
                }
                if (matrix[i][j] == 1) {
                    cost[i][j] = -1;
                    continue;
                }

                try {
                    valTop = cost[i-1][j];
                } catch (Exception e) {
                    valTop = Integer.MAX_VALUE;
                }
                try {
                    valLeft = cost[i][j-1];
                } catch (Exception e) {
                    valLeft = Integer.MAX_VALUE;
                }
                cost[i][j] = 1 + Math.min(valLeft, valTop);
            }
        }
        return cost;
    }


    public static void main(String[] args) {
        int [][] grid = {
                {0, 1, 1, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 1, 0, 1, 1},
                {1, 0, 0, 0, 0}
        };
        int [][] cost = findCostMatrix(grid);

    }

}
