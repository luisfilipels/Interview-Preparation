import java.util.LinkedList;

public class RottingOranges {

    private static class Coordinate {
        int r, c;

        Coordinate(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    private static boolean isValid (int [][] grid, boolean[][] visited, int r, int c) {
        return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && !visited[r][c] && grid[r][c] == 1;
    }

    private static int orangesRotting (int[][] grid) {
        int n = grid.length, m = grid[0].length;
        LinkedList<Coordinate> queue = new LinkedList<>();

        int countRotten = 0;
        int countFresh = 0;

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (grid[r][c] == 2) {
                    queue.add(new Coordinate(r, c));
                    countRotten++;
                } else if (grid[r][c] == 1) {
                    countFresh++;
                }
            }
        }

        if (countRotten == 0) {
            if (countFresh != 0) return -1;
            else return 0;
        } else {
            if (countFresh == 0) return 0;
        }

        int count = 0;
        boolean[][] visited = new boolean[n][m];

        while (!queue.isEmpty()) {
            int size = queue.size();
            count++;
            for (int i = 0; i < size; i++) {
                Coordinate current = queue.poll();
                int cr = current.r;
                int cc = current.c;
                grid[cr][cc] = 2;
                if (isValid(grid, visited, cr+1, cc)) {
                    visited[cr+1][cc] = true;
                    queue.add(new Coordinate(cr + 1, cc));
                }
                if (isValid(grid, visited,cr-1, cc)) {
                    visited[cr-1][cc] = true;
                    queue.add(new Coordinate(cr - 1, cc));
                }
                if (isValid(grid, visited, cr, cc+1)) {
                    visited[cr][cc+1] = true;
                    queue.add(new Coordinate(cr, cc + 1));
                }
                if (isValid(grid, visited, cr, cc-1)) {
                    visited[cr][cc-1] = true;
                    queue.add(new Coordinate(cr, cc - 1));
                }
            }
        }

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (grid[r][c] == 1) return -1;
            }
        }

        return count-1;
    }

    public static void main(String[] args) {
        int [][] arr = new int[][] {
                {2, 2}, {1, 1}, {0, 0}, {2, 0}
        };

        System.out.println(orangesRotting(arr));
    }

}
