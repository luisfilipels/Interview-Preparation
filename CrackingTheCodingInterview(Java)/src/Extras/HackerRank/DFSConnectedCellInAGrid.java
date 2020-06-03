package Extras.HackerRank;

import java.util.Stack;

public class DFSConnectedCellInAGrid {

    static class Coordinate {
        int l, c;

        Coordinate(int l, int c) {
            this.l = l;
            this.c = c;
        }
    }

    static int max = 0;

    static boolean isValid (int [][] grid, int l, int c) {
        int n = grid.length;
        int m = grid[0].length;
        return l >= 0 && l < n && c >= 0 && c < m && grid[l][c] == 1;
    }

    static void getRegionSize(int [][] grid, int l, int c) {
        Stack<Coordinate> stack = new Stack<>();

        stack.push(new Coordinate(l, c));
        int currentArea = 1;

        while (!stack.isEmpty()) {
            Coordinate current = stack.pop();
            int cl = current.l;
            int cc = current.c;
            grid[cl][cc] = 0;
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (isValid(grid, cl + i, cc + j)) {
                        if (i == 0 && j == 0) continue;
                        stack.push(new Coordinate(cl + i, cc + j));
                        grid[cl + i][cc + j] = 0;
                        currentArea++;
                    }
                }
            }
        }

        max = Math.max(max, currentArea);
    }

    static int maxRegion (int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        for (int l = 0; l < n; l++) {
            for (int c = 0; c < m; c++) {
                if (grid[l][c] == 1) {
                    getRegionSize(grid, l, c);
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int [][] grid = new int[][] {
                {1, 1, 0, 0},
                {0, 1, 1, 0},
                {0, 0, 1, 0},
                {1, 0, 0, 0}
        };

        System.out.println(maxRegion(grid));
    }

}
