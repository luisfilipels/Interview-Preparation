import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class FloodFill {

    // BFS-based solution
    private static class Coordinate {
        int row, col;

        Coordinate(int r, int c) {
            this.row = r;
            this.col = c;
        }
    }

    private static boolean isValid (int[][] image, boolean[][] visited, int r, int c, int oldColor) {
        int n = image.length;
        int m = image[0].length;
        return r >= 0 & r < n && c >= 0 && c < m && image[r][c] == oldColor && !visited[r][c];
    }

    private static int [][] floodFill (int [][] image, int sr, int sc, int newColor) {
        int colorToChange = image[sr][sc];

        boolean[][] visited = new boolean[image.length][image[0].length];

        Queue<Coordinate> queue = new ArrayDeque<>();
        queue.add(new Coordinate(sr, sc));

        while(!queue.isEmpty()) {
            Coordinate co = queue.poll();
            int r = co.row;
            int c = co.col;
            image[r][c] = newColor;
            visited[r][c] = true;
            if (isValid(image, visited, r+1, c, colorToChange)) queue.add(new Coordinate(r+1, c));
            if (isValid(image, visited, r-1, c, colorToChange)) queue.add(new Coordinate(r-1, c));
            if (isValid(image, visited, r, c+1, colorToChange)) queue.add(new Coordinate(r, c+1));
            if (isValid(image, visited, r, c-1, colorToChange)) queue.add(new Coordinate(r, c-1));
        }
        return image;
    }

    public static void main(String[] args) {
        int[][] image = new int[][] {
                {1,1,1}, {1,1,0},{1,0,1}
        };
        int sr = 1;
        int sc = 1;
        int newColor = 2;

        System.out.println(Arrays.deepToString(floodFill(image, sr, sc, newColor)));
    }

}
