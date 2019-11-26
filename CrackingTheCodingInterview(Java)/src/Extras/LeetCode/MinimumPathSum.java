package Extras.LeetCode;

public class MinimumPathSum {

    static private int minPathSum (int[][] grid) {
        for (int l = 0; l < grid.length; l++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (l-1 >= 0 && c - 1 >= 0) {
                    grid[l][c] += Math.min(grid[l-1][c], grid[l][c-1]);
                } else if (l-1 < 0 && c-1 >= 0) {
                    grid[l][c] += grid[l][c-1];
                } else if (l-1 >= 0 && c-1 < 0) {
                    grid[l][c] += grid[l-1][c];
                }
            }
        }
        return grid[grid.length-1][grid[0].length-1];
    }

    public static void main(String[] args) {
        int [][] input = new int[][] {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        System.out.println(minPathSum(input));
    }

}
