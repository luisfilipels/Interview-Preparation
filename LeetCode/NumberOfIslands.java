package Extras.LeetCode;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class NumberOfIslands {

    // Com fila chega a ser mais rápido e usa menos espaço.
    private static void floodFill(int l, int c, char[][]grid) {
        Stack<int[]> queue = new Stack<>();
        queue.add(new int[]{l, c});
        while (!queue.isEmpty()) {
            int[] current = queue.pop();
            int line = current[0];
            int column = current[1];
            if (line-1 >= 0 && line-1 < grid.length && column >= 0 && column < grid[0].length && grid[line-1][column] == '1') {
                grid[line-1][column] = '0';
                queue.add(new int[]{line-1, column});
            }
            if (line >= 0 && line < grid.length && column-1 >= 0 && column-1 < grid[0].length && grid[line][column-1] == '1') {
                grid[line][column-1] = '0';
                queue.add(new int[]{line, column-1});
            }
            if (line+1 >= 0 && line+1 < grid.length && column >= 0 && column < grid[0].length && grid[line+1][column] == '1') {
                grid[line+1][column] = '0';
                queue.add(new int[]{line+1, column});
            }
            if (line >= 0 && line < grid.length && column+1 >= 0 && column+1 < grid[0].length && grid[line][column+1] == '1') {
                grid[line][column+1] = '0';
                queue.add(new int[]{line, column+1});
            }
        }
    }

    private static int numIslands (char[][] grid) {
        int count = 0;
        for (int l = 0; l < grid.length; l++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[l][c] == '1') {
                    count++;
                    floodFill(l, c, grid);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        char[][] grid = new char[][] {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}};
        System.out.println(numIslands(grid));
    }

}
