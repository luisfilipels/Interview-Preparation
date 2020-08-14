import java.lang.reflect.Array;
import java.util.*;

public class C8Q2 {

    static class Coordinate {
        int l, c;
        Coordinate(int l, int c) {this.l = l; this.c = c;}
    }

    static final int W = Integer.MAX_VALUE;
    static final int F = Integer.MAX_VALUE-1;

    static LinkedList<Coordinate> robotInGrid (int [][] map) {
        /**for (int l = 0; l < map.length; l++) {
            for (int c = 0; c < map[0].length; c++) {
                if (l == 0 && c == 0) continue;
                if (map[l][c] == W)
                    continue;
                if (l == 0) {
                    map[l][c] = map[l][c-1] + 1;
                } else if (c == 0) {
                    map[l][c] = map[l-1][c] + 1;
                } else {
                    int min = Math.min(map[l-1][c], map[l][c-1]);
                    if (min == W || min == F) {
                        map[l-1][c] = W;
                        break;
                    }
                    map[l][c] = min + 1;
                }
            }
        }
        ArrayList<Coordinate> answer = new ArrayList<>();
        int l = map.length-1, c = map[0].length-1;
        answer.add(new Coordinate(l, c));
        while (true) {
            int above = l-1 >= 0 ? map[l-1][c] : W;
            int left = c-1 >= 0 ? map[l][c-1] : W;
            if (above < left) {
                l--;
            } else {
                c--;
            }
            answer.add(new Coordinate(l, c));
            if (l == 0 && c == 0) break;
        }
        return answer;*/
        boolean[][] visited = new boolean[map.length][map[0].length];
        findPath(map, visited, 0, 0, new LinkedList<Coordinate>());
        return response;
    }

    static boolean foundEnd = false;
    static LinkedList<Coordinate> response;

    static void findPath (int[][] map, boolean[][] visited, int l, int c, LinkedList<Coordinate> currentPath) {
        if (c >= map[0].length || l >= map.length || visited[l][c] || foundEnd) return;

        visited[l][c] = true;
        currentPath.add(new Coordinate(l, c));

        if (map[l][c] != W) {
            if (l == map.length-1 && c == map[0].length-1) {
                response = currentPath;
                foundEnd = true;
                return;
            }
            visited[l][c] = true;
            findPath(map, visited, l+1, c, new LinkedList<>(currentPath));
            findPath(map, visited, l, c+1, new LinkedList<>(currentPath));
        }
    }

    public static void main(String[] args) {
        int [][] grid = {
                {0, 0, 0, W, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, W, W, 0, 0},
                {W, W, 0, 0, W, 0, W, 0},
                {0, 0, 0, 0, 0, 0, 0, 0}
        };
        LinkedList<Coordinate> response = robotInGrid(grid);
        for (Coordinate c : response) {
            System.out.println(c.l + " " + c.c);
        }

    }

}
